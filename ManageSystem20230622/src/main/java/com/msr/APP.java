package com.msr;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.msr.mapper")
@EnableSwagger2Doc
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class,args);
    }
}
