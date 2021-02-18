package com.school.result;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.school.result.mapper")//入口扫描mapper接口
//@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@EnableSwagger2
public class ResultApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultApplication.class, args);
    }

}
