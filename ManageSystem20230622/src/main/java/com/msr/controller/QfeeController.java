package com.msr.controller;


import com.msr.entity.Feetype;
import com.msr.entity.Floor;
import com.msr.entity.Proprietor;
import com.msr.entity.Qfee;
import com.msr.query.ProprietorQuery;
import com.msr.query.QfeeQuery;
import com.msr.service.IFeetypeService;
import com.msr.service.IProprietorService;
import com.msr.service.IQfeeService;
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
 * @since 2023-07-08
 */
@Controller
@RequestMapping("/qfee")
@ResponseBody
public class QfeeController {
    @Autowired
    private IProprietorService proprietorService;
    @Autowired
    private IFeetypeService feetypeService;
    @Autowired
    private IQfeeService qfeeService;


    //分页方法
    @RequestMapping("/listPage")
    public PageUtils<Qfee> listPage(QfeeQuery qfeeQuery){
        PageUtils<Qfee> qfeePageUtils = qfeeService.pageQfeeList(qfeeQuery);
        List<Qfee> qfeeList = qfeePageUtils.getRows();//获取当前页的集合数据
        // 遍历处理proprietor中的user赋值
        for(Qfee qfee:qfeeList){
            // 根据id 获取对象
            Proprietor proprietor = proprietorService.getById(qfee.getProprietorid());
            Feetype feetype = feetypeService.getById(qfee.getFeetypeid());
            // 给对象赋值
            qfee.setProprietor(proprietor);
            qfee.setFeetype(feetype);
        }
        return qfeePageUtils;
    }

    // 加载下拉列表的集合数据
    @GetMapping("/qfee_type")
    public Results<Feetype> qfee_type(){
        List<Feetype> feetypeList = feetypeService.list();
        return Results.success(ResultCode.SUCCESS,feetypeList);
    }

    @GetMapping("/qfee_proprietor")
    public Results<Proprietor> qfee_proprietor(){
        List<Proprietor> proprietorList = proprietorService.list();
        return Results.success(ResultCode.SUCCESS,proprietorList);
    }


    // 保存
    @RequestMapping("/add_qfee")
    public Results<Qfee> add_qfee(Qfee qfee){
        try{
            if(qfee.getStatus() == null){
                qfee.setStatus(0);
            }
            qfeeService.save(qfee);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 编辑
    @RequestMapping("/edit_qfee")
    public Results<Qfee> edit_qfee(Qfee qfee){
        try{
            qfeeService.updateById(qfee);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 根据ID删除
    @RequestMapping("/del_qfee")
    public Results<Qfee> del_qfee(Integer id){
        try{
            qfeeService.removeById(id);
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

    // 批量删除
    @RequestMapping("/delBatch_qfee")
    public Results<Qfee> delBatch_qfee(Long[] ids){
        try{
            qfeeService.removeByIds(Arrays.asList(ids));// 把数组转换为集合
            return Results.success(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }

}
