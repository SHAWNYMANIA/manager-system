package com.msr.service;

import com.msr.entity.Qfee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.query.QfeeQuery;
import com.msr.utils.PageUtils;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bruce
 * @since 2023-07-08
 */
public interface IQfeeService extends IService<Qfee> {
    public PageUtils<Qfee> pageQfeeList(QfeeQuery qfeeQuery);
}
