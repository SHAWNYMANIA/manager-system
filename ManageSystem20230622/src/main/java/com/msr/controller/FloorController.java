package com.msr.controller;


import com.msr.entity.Floor;
import com.msr.entity.User;
import com.msr.query.FloorQuery;
import com.msr.service.IFloorService;
import com.msr.service.IUserService;
import com.msr.utils.PageUtils;
import com.msr.utils.ResultCode;
import com.msr.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bruce
 * @since 2023-06-23
 */
@Controller
@RequestMapping("/floor")
@ResponseBody
public class FloorController {
    @Autowired
    IFloorService floorService;
    @Autowired
    IUserService userService;
    //分页方法
    @RequestMapping("/listpage")
    public PageUtils<Floor> listpage(FloorQuery floorQuery){
        PageUtils<Floor> floorPageUtils = floorService.pageFloorList(floorQuery);
        List<Floor> floorList = floorPageUtils.getRows();//获取当前页的集合数据
        // 遍历处理floor中的user赋值
        for(Floor floor:floorList){
            // 根据userid 获取user对象
            User user = userService.getById(floor.getUserid());
            // 给floor中的user对象赋值
            floor.setUser(user);
        }
        return floorPageUtils;
    }

    // 加载下拉列表【楼管】的数据
    @GetMapping("/floor_user")
    public Results<User> floor_user(){
        return Results.success(ResultCode.SUCCESS,userService.list());
    }

    // 保存楼房
    @PostMapping("/add_floor")
    public Results<Floor> add_floor(Floor floor){
        try{
            floorService.save(floor);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 编辑楼房
    @PostMapping("/edit_floor")
    public Results<Floor> edit_floor(Floor floor){
        try{
            floorService.updateById(floor);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 根据ID删除楼房
    @PostMapping("/del_floor")
    public Results<Floor> del_floor(Integer id){
        try{
            floorService.removeById(id);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 批量删除楼房
    @PostMapping("/delBatch_floor")
    public Results<Floor> delBatch_floor(Long[] ids){
        try{
            floorService.removeByIds(Arrays.asList(ids));// 把数组转换为集合
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }
}
