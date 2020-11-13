package com.gvdroidframework.desire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gvdroidframework.desire")
@MapperScan(basePackages = "com.gvdroidframework.desire.repository")
public class DesireApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesireApplication.class, args);
    }
}
