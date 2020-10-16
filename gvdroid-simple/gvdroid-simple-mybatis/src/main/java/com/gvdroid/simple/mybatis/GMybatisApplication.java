package com.gvdroid.simple.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.gvdroid.simple.mybatis.repository"})
public class GMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(GMybatisApplication.class, args);
    }
}
