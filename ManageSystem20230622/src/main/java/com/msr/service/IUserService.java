package com.msr.service;

import com.msr.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bruce
 * @since 2023-06-22
 */
public interface IUserService extends IService<User>, UserDetailsService {

}
