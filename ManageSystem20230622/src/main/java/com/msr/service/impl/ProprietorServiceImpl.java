package com.msr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.entity.Floor;
import com.msr.entity.Proprietor;
import com.msr.mapper.ProprietorMapper;
import com.msr.query.ProprietorQuery;
import com.msr.service.IProprietorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.utils.PageUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bruce
 * @since 2023-06-29
 */
@Service
public class ProprietorServiceImpl extends ServiceImpl<ProprietorMapper, Proprietor> implements IProprietorService {

    @Override
    public PageUtils<Proprietor> pageProprietorList(ProprietorQuery proprietorQuery) {
        //构建条件查询对象
        QueryWrapper<Proprietor> proprietorQueryWrapper = new QueryWrapper<>();
        proprietorQueryWrapper.eq(proprietorQuery.getName()!=null && !proprietorQuery.getName().equals(""),"no",proprietorQuery.getName());
        //
        //获取当前页码 = (开始下标索引 / 每页显示的大小) + 1
        Long currPage = (proprietorQuery.getOffset() / proprietorQuery.getPage())+1;
        //获取分页插件对象
        IPage<Proprietor> proprietorIPage = this.page(new Page<Proprietor>(currPage,proprietorQuery.getPage()),proprietorQueryWrapper);

        return new PageUtils<Proprietor>(proprietorIPage.getTotal(),proprietorIPage.getRecords());
    }
}
