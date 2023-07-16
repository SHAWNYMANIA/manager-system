package com.msr.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

//用户封装
public class UserSecurity extends User {
    // 自定义用户对象
    @Getter
    @Setter
    private com.msr.entity.User loginUser;

    public UserSecurity(com.msr.entity.User user, Set<GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(),true,true,true,true, authorities);
        this.loginUser = user; //把SpringSecurity里面的User用户封装成了我们自己的用户对象user
    }
}
