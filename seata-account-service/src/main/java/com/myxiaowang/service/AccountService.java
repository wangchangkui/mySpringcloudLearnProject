package com.myxiaowang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxiaowang.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:20:00
 */

public interface AccountService extends IService<Account> {
    /**
     * 扣减账户余额
     * @param userId 扣减账户的用户id
     * @param money 扣减的金额
     * @return 操作结果
     */

    String deduct(Long userId, BigDecimal money);
}
