package com.myxiaowang.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:20:00
 */

@FeignClient(value = "seata-account-service")
public interface AccountService  {
    /**
     * 扣减账户余额
     * @param userId 扣减账户的用户id
     * @param money 扣减的金额
     * @return 操作结果
     */
    @PostMapping("/account/deduct")
    String deduct(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
