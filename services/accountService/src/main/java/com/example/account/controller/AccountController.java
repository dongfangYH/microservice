package com.example.account.controller;

import com.example.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-12-01 16:32
 **/
@RestController
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/decrease")
    public String decrease(Long userId, BigDecimal money) {
        accountService.decrease(userId,money);
        return "用户账户扣减金额成功";
    }
}

