package com.msr.controller;


import com.msr.entity.Proprietor;
import com.msr.utils.QiNiuUtils;
import com.msr.utils.ResultCode;
import com.msr.utils.Results;
import com.msr.utils.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class FileUploadController {
//    @RequestMapping("/upload")
//    @ResponseBody
//    public Results<Proprietor> upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
//        //上传图片
//        //MultipartFile file 上传文件对象
//        //HttpServletResponse response 响应对象
//        //String imgPath 保存文件的路径
//        try {
//            //返回文件名
//            String fileName = UploadUtils.upload(file,response,"/static/upload");
//            return Results.success(ResultCode.FILE_SUCCESS,fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return Results.fail(ResultCode.FILE_FAIL);
//        }
//    }

    @RequestMapping("/QiniuUpload")
    @ResponseBody
    public Results<Proprietor> QiniuUpload(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        //获取原有的图片的名称
        try {
            String fileName = file.getOriginalFilename();
            QiNiuUtils.uploadViaByte(file.getBytes(),"proprietor/"+fileName);
            //http://rx9o8lnka.sabkt.gdipper.com/proprietor/blue.png
            //---------七牛云给的域名--------------===目录名===--文件名--
            //拼接完整的图片路径
            String pathImg = QiNiuUtils.DOMAIN + "/proprietor/" + fileName;
            return Results.success(ResultCode.FILE_SUCCESS,pathImg);
        } catch (Exception e) {
            e.printStackTrace();
            return Results.fail(ResultCode.FILE_FAIL);
        }
    }
}
