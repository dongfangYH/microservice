package com.example.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.example.service.mapper")
@EnableEurekaClient
@SpringBootApplication
public class PlainServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlainServiceApplication.class, args);
    }

}
