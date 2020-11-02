package com.example.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/demo/info")
    public String demo(){
        return "server port : " + port;
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return "hello -> " + name;
    }
}
