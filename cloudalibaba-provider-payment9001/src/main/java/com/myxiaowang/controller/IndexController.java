package com.myxiaowang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年06月07日 13:08:00
 */
@RestController
public class IndexController {

    @GetMapping("/hello/nacos")
    public String index(){
        return "Hello nacos 9001";
    }
}
