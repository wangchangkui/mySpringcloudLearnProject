package com.myxiaowang.service;

import com.myxiaowang.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月14日 13:27:00
 */
@Component
public class PaymentFeignDefaultErrorService implements PaymentFeignServices {
    @Override
    public String save(Payment payment) {
        return "新建订单接口出现了异常，请联系管理";
    }

    @Override
    public String findById(Long id) {
        return "查询订单ID接口出现了异常，请联系管理";
    }
}
