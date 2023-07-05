package com.msr.controller;


import com.msr.entity.Floor;
import com.msr.entity.Proprietor;
import com.msr.query.ProprietorQuery;
import com.msr.service.IFloorService;
import com.msr.service.IProprietorService;
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
 * @since 2023-06-29
 */
@Controller
@RequestMapping("/proprietor")
@ResponseBody
public class ProprietorController {
    @Autowired
    private IProprietorService proprietorService;
    @Autowired
    private IFloorService floorService;

    //分页方法
    @RequestMapping("/listpage")
    public PageUtils<Proprietor> listpage(ProprietorQuery proprietorQuery){
        PageUtils<Proprietor> proprietorPageUtils = proprietorService.pageProprietorList(proprietorQuery);
        List<Proprietor> proprietorList = proprietorPageUtils.getRows();//获取当前页的集合数据
        // 遍历处理proprietor中的user赋值
        for(Proprietor proprietor:proprietorList){
            // 根据userid 获取user对象
            Floor floor = floorService.getById(proprietor.getFloorid());
            // 给floor中的user对象赋值
            proprietor.setFloor(floor);
        }
        return proprietorPageUtils;
    }

    // 加载下拉列表【楼房】的集合数据
    @GetMapping("/load_floor")
    public Results<Floor> load_floor(Proprietor proprietor){
        List<Floor> floorList = floorService.list();
        return Results.success(ResultCode.SUCCESS,floorList);
    }

    // 保存业主
    @PostMapping("/add_proprietor")
    public Results<Proprietor> add_proprietor(Proprietor proprietor){
        try{
            proprietorService.save(proprietor);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 编辑业主
    @PostMapping("/edit_proprietor")
    public Results<Proprietor> edit_proprietor(Proprietor proprietor){
        try{
            proprietorService.updateById(proprietor);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 根据ID删除业主
    @PostMapping("/del_proprietor")
    public Results<Proprietor> del_proprietor(Integer id){
        try{
            proprietorService.removeById(id);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 批量删除业主
    @PostMapping("/delBatch_proprietor")
    public Results<Proprietor> delBatch_proprietor(Long[] ids){
        try{
            proprietorService.removeByIds(Arrays.asList(ids));// 把数组转换为集合
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

}
