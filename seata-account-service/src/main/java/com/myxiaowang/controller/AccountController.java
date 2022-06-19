package com.myxiaowang.controller;

import com.myxiaowang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:24:00
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;


    @PostMapping("/account/deduct")
    String deduct(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        return accountService.deduct(userId, money);
    }
}
