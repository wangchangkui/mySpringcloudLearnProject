package com.myxiaowang.service.impl;

import com.myxiaowang.service.AccountService;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:23:00
 */
@Slf4j
public class AccountServiceImpl  implements AccountService {

    @Override
    public String deduct(Long userId, BigDecimal money) {
        log.error("扣减账户余额异常");
        return "fail";
    }
}

