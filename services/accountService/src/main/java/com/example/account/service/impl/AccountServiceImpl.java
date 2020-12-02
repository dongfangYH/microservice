package com.example.account.service.impl;

import com.example.account.service.AccountService;
import com.example.account.tcc.AccountTccAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-12-01 16:26
 **/
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountTccAction accountTccAction;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        // accountMapper.decrease(userId,money);
        accountTccAction.prepareDecreaseAccount(null, userId, money);
    }
}
