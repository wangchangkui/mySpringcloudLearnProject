package com.myxiaowang.service;

import com.myxiaowang.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月18日 20:42:00
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVER")
public interface PaymentFeignService {

    /**
     * 添加用户信息
     * @param payment 用户信息
     * @return 用户信息
     */
    @PostMapping("/payment/save")
   String save(Payment payment);
    /**
     * 获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/payment/findById/{id}")
    String findById(@PathVariable("id") Long id);
}
