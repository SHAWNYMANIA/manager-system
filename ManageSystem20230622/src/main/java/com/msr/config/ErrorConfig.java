package com.msr.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

//统一页面状态异常管理类
@Configuration
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500");
        ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN,"/403");
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404");

        registry.addErrorPages(errorPage500,errorPage403,errorPage404);
    }
}
