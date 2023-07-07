package com.msr;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@MapperScan("com.msr.mapper")
@EnableSwagger2Doc
@SpringBootApplication
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class,args);
    }
}
