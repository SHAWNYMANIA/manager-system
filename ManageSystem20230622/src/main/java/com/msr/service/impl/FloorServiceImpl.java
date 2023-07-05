package com.msr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.entity.Floor;
import com.msr.mapper.FloorMapper;
import com.msr.query.FloorQuery;
import com.msr.service.IFloorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.utils.PageUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bruce
 * @since 2023-06-23
 */
@Service
public class FloorServiceImpl extends ServiceImpl<FloorMapper, Floor> implements IFloorService {

    @Override
    public PageUtils<Floor> pageFloorList(FloorQuery floorQuery) {
        //构建条件查询对象
        QueryWrapper<Floor> floorQueryWrapper = new QueryWrapper<>();
        floorQueryWrapper.eq(floorQuery.getNo()!=null && !floorQuery.getNo().equals(""),"no",floorQuery.getNo());
        floorQueryWrapper.eq(floorQuery.getFloor()!=null && !floorQuery.getFloor().equals(""),"floor",floorQuery.getFloor());
        //
        //获取当前页码 = (开始下标索引 / 每页显示的大小) + 1
        Long currPage = (floorQuery.getOffset() / floorQuery.getPage())+1;
        //获取分页插件对象
        IPage<Floor> floorIPage = this.page(new Page<Floor>(currPage,floorQuery.getPage()),floorQueryWrapper);

        return new PageUtils<Floor>(floorIPage.getTotal(),floorIPage.getRecords());
    }
}
