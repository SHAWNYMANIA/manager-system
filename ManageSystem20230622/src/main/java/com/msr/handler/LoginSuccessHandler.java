package com.msr.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msr.utils.ResultCode;
import com.msr.utils.Results;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 成功的处理器
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //处理中文乱码
        response.setContentType("application/json;charset=utf-8");
        // 往前段回传成功的信息 : java格式数据
        Results dataResults = Results.success(ResultCode.LOGIN_SUCCESS);
        // 转换成json格式
        response.getWriter().write(new ObjectMapper().writeValueAsString(dataResults));
        return;
    }
}
