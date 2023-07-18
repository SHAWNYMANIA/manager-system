package com.msr.service.impl;

import com.msr.entity.Menu;
import com.msr.mapper.MenuMapper;
import com.msr.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bruce
 * @since 2023-07-18
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAll(Long userid) {
        return menuMapper.findAll(userid);
    }
}
