package com.msr.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msr.config.UserSecurity;
import com.msr.entity.Menu;
import com.msr.service.IMenuService;
import com.msr.utils.ResultCode;
import com.msr.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 成功的处理器
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private IMenuService menuService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 处理中文乱码
        response.setContentType("application/json;charset=utf-8");

        // 使用security中提供的工具类获取"封装对象",获取认证对象
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // 把认证对象，转换为封装对象
        UserSecurity userSecurity = auth!=null ? (UserSecurity)auth.getPrincipal(): null;

        // 登录成功后 加载登陆者的菜单信息
        List<Menu> menuList = menuService.findAll(Long.valueOf(userSecurity.getLoginUser().getId())); // id←用户对象←封闭用户对象
        if(menuList!=null){
            request.getSession().setAttribute("menuList",menuList);
        }

        // 往前段回传成功的信息 : java格式数据
        Results dataResults = Results.success(ResultCode.LOGIN_SUCCESS);
        // 转换成json格式
        response.getWriter().write(new ObjectMapper().writeValueAsString(dataResults));
        return;
    }
}
