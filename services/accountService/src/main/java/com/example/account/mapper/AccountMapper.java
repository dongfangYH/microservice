package com.example.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.account.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountMapper extends BaseMapper<Account> {

    void decrease(Long userId, BigDecimal money);

    void updateFrozen(@Param("userId") Long userId, @Param("residue") BigDecimal residue, @Param("frozen") BigDecimal frozen);

    void updateFrozenToUsed(@Param("userId") Long userId, @Param("money") BigDecimal money);

    void updateFrozenToResidue(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

