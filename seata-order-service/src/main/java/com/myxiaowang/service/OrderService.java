package com.myxiaowang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxiaowang.entity.Order;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月13日 22:34:00
 */
public interface OrderService extends IService<Order> {

    /**
     * 微服务创建订单
     * @param order 订单信息
     */
    String create(Order order);
}
