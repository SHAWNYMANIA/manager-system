package com.msr.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.msr.entity.Qfee;
import com.msr.service.IQfeeService;
import com.msr.utils.ResultCode;
import com.msr.utils.Results;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController//@controller和@Responsebody可以合并写为@RestController
public class EasyPOIController {
    //定义QfeeService对象
    @Autowired
    private IQfeeService qfeeService;

    // 导出Excel方法
    @GetMapping("/exportQfee")
    public Results<Qfee> export(HttpSession session){
        try {
            // 设置导出信息
            ExportParams params = new ExportParams();
            // 设置标题
            params.setTitle("欠缴费列表数据");
            // 设置sheet名称
            params.setSheetName("欠缴费列表");

            // ExportParams entity : params
            // Class<?> pojoClass : 实体
            // Collection<?> dataSet : 集合数据

            // 从session获取集合数组
            List<Qfee> qfeeList = (List<Qfee>)session.getAttribute("qfeeList");
            Workbook workbook = ExcelExportUtil.exportExcel(params,Qfee.class,qfeeList);

            // 通过输出流导出文件
            FileOutputStream outputStream = new FileOutputStream("D:\\JavaTest\\qfee.xlsx");
            workbook.write(outputStream);

            return Results.success(ResultCode.SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FAIL);
        }

    }


    // 导入Excel方法
    @PostMapping("/importQfee")
    public Results<Qfee> importQfee(@RequestParam("file")MultipartFile file){
        // 加载Excel文件（为上方获取的file文件）
        // 选择Sheet,params默认选择第一个sheet
        try {
            ImportParams params = new ImportParams();
            // 读取第几个sheet
            params.setStartSheetIndex(0);
            // 每次读取几个sheet
            params.setSheetNum(1);
            // 标题占几行
            params.setTitleRows(1);
            // 头部占几行
            params.setHeadRows(1);
            // 校验导入字段（无）
            // 数据解析(mapping映射), pojoClass映射
            List<Qfee> resultList = ExcelImportUtil.importExcel(file.getInputStream(), Qfee.class,params);
            resultList.forEach(obj -> System.out.println(obj));

//            for(Qfee qfee : resultList){
//                qfeeService.save(qfee);
//            }
            qfeeService.saveBatch(resultList);

            return Results.success(ResultCode.SUCCESS,resultList);
        } catch (Exception e) {
            e.printStackTrace();

            return Results.fail(ResultCode.FAIL);
        }
    }
}
