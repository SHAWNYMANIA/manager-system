package com.msr.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.msr.entity.User;
import com.msr.service.IUserService;
import com.msr.utils.ResultCode;
import com.msr.utils.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bruce
 * @since 2023-06-22
 */
@Controller
@RequestMapping("/user")
@Api(tags = "用户信息的API", description = "提供用户信息相关的 Rest API")
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping("/findAll")
    @ApiOperation(value = "用户列表",
                notes = "用户列表",
                httpMethod = "GET")
    public Results<User> findAll(){
        List<User> userList = userService.list();
        return Results.success(ResultCode.SUCCESS,userList);
    }

    //登录业务处理
    @ResponseBody
    @PostMapping("/login")
    public Results<User> login(User user, HttpSession session){
        System.out.println(user.getUsername()+"\t"+user.getPassword());
        //条件构造器 select * from User where username = ? and password = ?
        QueryWrapper<User> userWrapper = new QueryWrapper();
        userWrapper.eq("username",user.getUsername());
        userWrapper.eq("password",user.getPassword());

        List<User> userList = userService.list(userWrapper);
        if(userList.size()>0){
            //登录成功
            session.setAttribute("USER",userList.get(0));
            return Results.success(ResultCode.LOGIN_SUCCESS);
        }else{
            //登录失败
            return Results.fail(ResultCode.LOGIN_FAIL);
        }

    }
}
