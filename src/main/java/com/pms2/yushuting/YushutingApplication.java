package com.pms2.yushuting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2 //加上注解@EnableSwagger2 表示开启Swagger
@SpringBootApplication
@MapperScan("com.pms2.yushuting.mapper")
public class YushutingApplication {
    public static void main(String[] args) {
        SpringApplication.run(YushutingApplication.class, args);
    }

}
