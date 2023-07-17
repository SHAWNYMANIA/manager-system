package com.msr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//页面跳转controller
@Controller
@RequestMapping
public class PageController {

    //跳转到index页面 @return
    @RequestMapping("/index")
    public String toIndex(){
        return "views/index";
    }

    //跳转到login页面 @return
    @RequestMapping("/login")
    public String toLogin(){
        return "views/login";
    }

    //登录退出 @return
    @RequestMapping("/logout")
    public String tologout(HttpSession session){
        //清空session对象
        session.invalidate();
        return "views/login";
    }

    //跳转到floor_list页面
    @RequestMapping("/floor_list")
    public String floor_list(){
        return "views/floor/floor_list";
    }

    //跳转到proprietor_list页面
    @RequestMapping("/proprietor_list")
    public String proprietor_list(){
        return "views/proprietor/proprietor_list";
    }

    //跳转到fee_list页面
    @RequestMapping("/fee_list")
    public String fee_list(){
        return "views/fee/fee_list";
    }

    //跳转到500页面
    @RequestMapping("/500")
    public String error500(){
        return "/views/error500";
    }

    //跳转到404页面
    @RequestMapping("/404")
    public String error404(){
        return "/views/error404";
    }

    //跳转到403页面
    @RequestMapping("/403")
    public String error403(){
        return "/views/error403";
    }
}
