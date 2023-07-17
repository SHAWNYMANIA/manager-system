package com.msr.service;

import com.msr.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bruce
 * @since 2023-07-17
 */
public interface IRoleService extends IService<Role> {
    public List<Role> listRolesByUserId(Long userId);
}
