package com.myxiaowang.controller;

import com.myxiaowang.util.Reslut.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 16:26:00
 */
@RestController
public class ServiceInfoController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service-info")
    public ResponseResult<List<String> > getDiscovery(){
        List<String> services = discoveryClient.getServices();
        return ResponseResult.success(services);
    }
}
