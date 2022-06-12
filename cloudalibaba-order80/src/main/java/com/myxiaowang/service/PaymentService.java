package com.myxiaowang.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月12日 16:44:00
 */
@FeignClient(name = "nacos-payment-provider",fallback = FallBackServiceImpl.class)
public interface PaymentService {

    @GetMapping("/hello/nacos")
    String helloNacos();
}
