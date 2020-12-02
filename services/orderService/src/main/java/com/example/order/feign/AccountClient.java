package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "account")
public interface AccountClient {
    @GetMapping("/decrease")
    String decrease(@RequestParam(value = "userId") Long userId,
                    @RequestParam(value = "money") BigDecimal money);
}

