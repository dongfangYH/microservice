package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-21 09:38
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
@EnableMongoRepositories(basePackages = "com.example.zuul.dao")
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
