package com.example.feign.remote;

import com.example.feign.config.FeignConfig;
import com.example.feign.fallback.HelloServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "plainService", configuration = FeignConfig.class, fallback = HelloServiceFallBack.class)
public interface HelloService {

    @GetMapping(value = "/sayHello")
    String callRemote(@RequestParam("name") String name);
}
