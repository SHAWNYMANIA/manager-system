package com.msr.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author tom
 * @version V1.0
 * @Package com.msr.utils
 * @date 2022/9/22 17:19
 * @Copyright © 株式会社多言语系统研究所
 */
public class UploadUtils {
    public static String upload(MultipartFile file, HttpServletResponse response, String imgPath) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if (file.isEmpty()) {
            response.getWriter().write("<script>alert('户型图片不能为空!');location.href='/page_saveFood';</script>");
            return null;
        }
        //文件名
        String fileName = file.getOriginalFilename();
        //后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //大小（单位是字节，可以加入判断）
        int size = (int) file.getSize();
        System.out.println("后缀名：" + suffixName);
        System.out.println("文件名：" + fileName);
        System.out.println("文件大小：" + size);
        //最后保存的文件名
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("最后保存的文件名称：" + fileName);

        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println("path:" + path.getAbsolutePath());
        //如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),imgPath);

        //获取真实的服务器路径
        File f = new File(upload.getAbsolutePath(), fileName);
        //检测是否存在该目录
        if (!f.getParentFile().exists()) {
            //不存在则创建当前目录
            f.getParentFile().mkdirs();
        }
        file.transferTo(f);
        System.out.println("文件上传成功,路径是:" + f.getAbsolutePath());
        return fileName;
    }
}
