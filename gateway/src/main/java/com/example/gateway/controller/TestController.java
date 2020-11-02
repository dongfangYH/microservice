package com.example.gateway.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-26 10:11
 **/
@RestController
public class TestController {

    @Resource
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/testLB")
    public String testLB(){
        return loadBalancerClient.toString();
    }

}
