package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.mapper")
public class EvaluateApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvaluateApplication.class, args);
    }
}
