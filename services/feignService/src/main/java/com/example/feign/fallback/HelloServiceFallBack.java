package com.example.feign.fallback;

import com.example.feign.remote.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallBack implements HelloService {
    @Override
    public String callRemote(String name) {
        return "fallback call : " + name;
    }
}
