package com.myxiaowang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxiaowang.dao.AccountMapper;
import com.myxiaowang.entity.Account;
import com.myxiaowang.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:23:00
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account>  implements AccountService {

    @Override
    public String deduct(Long userId, BigDecimal money) {
        log.info("传入参数：{},{}", userId, money);
        log.info("查询账户信息");
        Account account = getOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId));
        log.info("更新账户信息");
        account.setResidue(account.getResidue().subtract(money));
        account.setUsed(account.getUsed().add(money));
        updateById(account);
        return "success";
    }
}

