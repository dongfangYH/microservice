package com.example.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class CallController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/call")
    public String call(){
        String name = UUID.randomUUID().toString();
        return restTemplate.getForObject("http://plainService/sayHello?name=" + name, String.class);
    }

    public String fallback(){
        return "fallback";
    }


    @GetMapping("/loadBalance")
    public String hello(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("plainService");
        return serviceInstance.getHost() + ":" + serviceInstance.getPort();
    }
}
