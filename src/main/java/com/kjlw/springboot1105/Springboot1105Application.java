package com.kjlw.springboot1105;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kjlw.springboot1105.mapper")
public class Springboot1105Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1105Application.class, args);
    }

}
