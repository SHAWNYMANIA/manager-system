package com.msr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.entity.Feetype;
import com.msr.entity.Qfee;
import com.msr.mapper.QfeeMapper;
import com.msr.query.QfeeQuery;
import com.msr.service.IFeetypeService;
import com.msr.service.IQfeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bruce
 * @since 2023-07-08
 */
@Service
public class QfeeServiceImpl extends ServiceImpl<QfeeMapper, Qfee> implements IQfeeService {
    @Autowired
    private IFeetypeService feetypeService;

    @Override
    public PageUtils<Qfee> pageQfeeList(QfeeQuery qfeeQuery) {
        QueryWrapper<Qfee> qfeeQueryWrapper = new QueryWrapper<>();
        qfeeQueryWrapper.eq(qfeeQuery.getQfno()!=null && !(qfeeQuery.getQfno().equals("")),"qfno",qfeeQuery.getQfno());

        if(qfeeQuery.getTitle()!=null && !(qfeeQuery.getTitle().equals(""))){
            QueryWrapper<Feetype> feetypeQueryWrapper = new QueryWrapper<>();
            feetypeQueryWrapper.eq("title",qfeeQuery.getTitle());
            List<Integer> ids = new ArrayList<>();
            for(Feetype feetype : feetypeService.list(feetypeQueryWrapper)){
                ids.add(feetype.getId());
            }
            qfeeQueryWrapper.in("feetypeid", ids);
        }
        Long currPage = qfeeQuery.getOffset() / qfeeQuery.getPage() + 1;
        IPage<Qfee> qfeeIPage = this.page(new Page<Qfee>(currPage, qfeeQuery.getPage()),qfeeQueryWrapper);
        return new PageUtils<Qfee>(qfeeIPage.getTotal(),qfeeIPage.getRecords());
    }
}
