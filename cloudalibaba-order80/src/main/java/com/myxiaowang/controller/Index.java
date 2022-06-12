package com.myxiaowang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

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
    @SentinelResource(value = "fallback", fallback = "fallback",blockHandler = "blockHandler")
    //可以忽略某个异常
    //@SentinelResource(value = "fallback", fallback = "fallback",blockHandler = "blockHandler",exceptionsToIgnore = {RuntimeException.class})
    public String index(@PathParam("id") Long id){
        if(id == 4){
            throw new RuntimeException("id is 4");
        }
        return restTemplate.getForObject(serverUrl+"/hello/nacos",String.class);
    }

    public String fallback(@PathParam("id") Long id, Throwable e){
        return "id is 4";
    }

    public String blockHandler(@PathParam("id") Long id, BlockException e){
        return "请求次数过多";
    }


}
