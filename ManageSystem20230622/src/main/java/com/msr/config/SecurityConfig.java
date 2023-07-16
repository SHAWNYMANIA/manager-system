package com.msr.config;

import com.msr.handler.LoginFailureHandler;
import com.msr.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //表示开启Security配置
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    UserDetailsService userDetailsService;

    // 登陆
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加密内存模拟登陆
//       auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder()) // 指定密码加密编辑器
//               .withUser("tom")
//               .password(new BCryptPasswordEncoder().encode("123"))
//               .roles("USER");

//        // 不加密内存模拟登陆
//        auth.inMemoryAuthentication()
//                .withUser("tom")
//                .password("{noop}123")
//                .roles("USER");

        // 基于数据库登陆方式
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    // 配置认证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //支持项目中的框架frame布局,同源: 协议相同http:  IP相同 127.0.0.1  端口相同80
        http.headers().frameOptions().sameOrigin();

        http.authorizeRequests()
                //放行路径，不需要认证
                .antMatchers("/static/**")
                .permitAll() //以上放行
                .antMatchers("/**").hasAnyRole("USER")//其它的需要USER角色
                .anyRequest().authenticated()//其它请求，必须登录
                .and() //并且
                .formLogin()//采用表单登录
                //如果没有认证，则跳转到自定义登录页面：login.html
                .loginPage("/login")
                //登录的后台控制器地址
                .loginProcessingUrl("/login")
                //配置用户名,默认值：username
                .usernameParameter("username")
                //配置用户密码,默认值：password
                .passwordParameter("password")
                //登录成功，跳转到：index.html  【同步】
                //.successForwardUrl("/index")
                //登录失败，跳转到：fail.html  【同步】
                //.failureForwardUrl("/fail")
                //登录成功跳转  【异步】
                .successHandler(loginSuccessHandler)
                //登录失败跳转  【异步】
                .failureHandler(loginFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")  //系统注销的控制器地址
                .invalidateHttpSession(true) //注销成功清空会话
                .logoutSuccessUrl("/login")//注销后跳转的地址
                .permitAll()
                .and()
                .csrf()
                .disable();//禁用CSRF请求伪造攻击防御
    }
}
