package com.myxiaowang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.myxiaowang.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.*;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月09日 22:14:00
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() throws InterruptedException {
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


    @GetMapping("/c")
    @SentinelResource(value = "c",blockHandler = "errorHandler")
    public String c(@RequestParam("key") String key) {
        return "c" + key;
    }

    public String errorHandler(String key, BlockException e){
        return "限流参数："+key;
    }


    @GetMapping("/e")
    @SentinelResource(value = "e")
    public String e(@RequestParam("key") String key) {
        return "e" + key;
    }


    @GetMapping("/f")
    @SentinelResource(value = "f",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "errorHandler1")
    public String f() {
        return  "f";
    }



    public String customerErrorHandler(BlockException e){
        return "用户自定义限流逻辑";
    }
}
