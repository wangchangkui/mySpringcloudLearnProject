package com.myxiaowang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxiaowang.dao.OrderMapper;
import com.myxiaowang.entity.Order;
import com.myxiaowang.service.AccountService;
import com.myxiaowang.service.OrderService;
import com.myxiaowang.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月13日 22:34:00
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @GlobalTransactional(name = "order-create-tx")
    @Override
    public String create(Order order) {
        log.info("订单创建，待插入的订单：{}", order);
        orderMapper.insert(order);

        log.info("订单微服务调用开始，准备减库存");
        String storage = storageService.deduct(order.getProductId(), order.getCount());

        log.info("账户微服务调用开始，准备扣除账户余额");
        String account = accountService.deduct(order.getUserId(), order.getMoney());

        log.info("修改订单状态");
        order.setStatus(1);
        orderMapper.update(order, new LambdaQueryWrapper<Order>().eq(Order::getUserId, order.getUserId()));

        return "订单创建成功";
    }
}
