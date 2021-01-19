package com.school.result;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.school.result.mapper")//入口扫描mapper接口
public class ResultApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultApplication.class, args);
    }

}
