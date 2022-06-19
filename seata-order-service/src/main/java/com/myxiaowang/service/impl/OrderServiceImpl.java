package com.myxiaowang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxiaowang.dao.OrderMapper;
import com.myxiaowang.entity.Order;
import com.myxiaowang.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月13日 22:34:00
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
