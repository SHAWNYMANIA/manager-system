package com.msr.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msr.utils.ResultCode;
import com.msr.utils.Results;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 失败的处理器
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //处理中文乱码
        response.setContentType("application/json;charset=utf-8");
        // 往前段回传成功的信息 : java格式数据
        Results dataResults = Results.fail(ResultCode.LOGIN_FAIL);
        // 转换成json格式
        response.getWriter().write(new ObjectMapper().writeValueAsString(dataResults));
        return;
    }
}
