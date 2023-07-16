package com.msr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.msr.config.UserSecurity;
import com.msr.entity.User;
import com.msr.mapper.UserMapper;
import com.msr.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bruce
 * @since 2023-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 构建条件对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 根据用户名检索
        queryWrapper.eq("username",username); //zs
        // 进行集合查询
        List<User> userList = this.list(queryWrapper);
        if(userList.size()>0){
            User user = userList.get(0);
            if(user!=null){
                // 创建权限集合
                HashSet<GrantedAuthority> auth =new HashSet<GrantedAuthority>();
                auth.add(new SimpleGrantedAuthority("ROLE_USER"));
                return new UserSecurity(user,auth);
            }else{
                return null;
            }
        }else {
            return null;
        }

    }
}
