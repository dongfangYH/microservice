package com.example.feign.controller;

import com.example.feign.remote.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {
    @Resource
    private HelloService helloService;
    @GetMapping("/feign")
    public String feign(){
        return helloService.callRemote("feign");
    }
}
