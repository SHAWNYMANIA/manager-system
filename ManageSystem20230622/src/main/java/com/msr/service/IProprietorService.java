package com.msr.service;

import com.msr.entity.Floor;
import com.msr.entity.Proprietor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.query.FloorQuery;
import com.msr.query.ProprietorQuery;
import com.msr.utils.PageUtils;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bruce
 * @since 2023-06-29
 */
public interface IProprietorService extends IService<Proprietor> {
    // 分页楼房方法
    public PageUtils<Proprietor> pageProprietorList(ProprietorQuery proprietorQuery);
}

