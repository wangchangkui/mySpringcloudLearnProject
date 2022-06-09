package com.myxiaowang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月09日 22:14:00
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/a")
    public String a() {
        return "a";
    }

    @GetMapping("/b")
    public String b() {
        return "b";
    }
}
