package com.myxiaowang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年06月07日 13:25:00
 */
@RestController
public class Index {

    private final String serverUrl="http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/hello/nacos")
    public String index(){
        return restTemplate.getForObject(serverUrl+"/hello/nacos",String.class);
    }
}
