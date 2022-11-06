package com.myxiaowang.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 17:36:00
 */
@RestController
public class TestController {

    @GetMapping("/index")
    @PreAuthorize("hasAnyAuthority('User')")
    public String index(){
        return "index";
    }

    @GetMapping("/aaa")
    public String aaa(){
        return "aaa";
    }
}
