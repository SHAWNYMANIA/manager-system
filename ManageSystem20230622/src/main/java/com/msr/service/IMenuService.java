package com.msr.service;

import com.msr.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bruce
 * @since 2023-07-18
 */
public interface IMenuService extends IService<Menu> {
    //根据登录的用户id，查询对应的菜单列表信息
    public List<Menu> findAll(Long userid);
}
