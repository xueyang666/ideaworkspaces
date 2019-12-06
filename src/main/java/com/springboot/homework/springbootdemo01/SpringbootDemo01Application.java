package com.springboot.homework.springbootdemo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.homework.springbootdemo01.mapper")
public class SpringbootDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo01Application.class, args);
    }

}
