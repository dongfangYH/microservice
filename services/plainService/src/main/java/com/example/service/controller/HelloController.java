package com.example.service.controller;

import com.example.service.config.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RefreshScope
@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @Resource
    private ConfigInfoProperties configInfoProperties;

    @GetMapping("/demo/info")
    public String demo(){
        return "server port : " + port;
    }

    @GetMapping("/config")
    public String config(){
        return configInfoProperties.getEnv();
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return "hello -> " + name;
    }
}
