package com.myxiaowang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月15日 21:37:00
 */
@RestController
public class ConfigController {

    @Value("${key.passwpord}")
    private String password;

    @GetMapping("/password")
    public String password(){
        return password;
    }
}
