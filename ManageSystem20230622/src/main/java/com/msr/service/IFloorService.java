package com.msr.service;

import com.msr.entity.Floor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.query.FloorQuery;
import com.msr.utils.PageUtils;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bruce
 * @since 2023-06-23
 */
public interface IFloorService extends IService<Floor> {
    // 分页楼房方法
    public PageUtils<Floor> pageFloorList(FloorQuery floorQuery);
}
