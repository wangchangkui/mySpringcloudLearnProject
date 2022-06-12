package com.myxiaowang.service;

import org.springframework.stereotype.Service;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月12日 16:50:00
 */

@Service
public class FallBackServiceImpl implements PaymentService{
    @Override
    public String helloNacos() {
        return "服务降级返回";
    }

}
