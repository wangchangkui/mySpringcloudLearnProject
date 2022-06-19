package com.myxiaowang.controller;

import com.myxiaowang.entity.Order;
import com.myxiaowang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月13日 22:35:00
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/orderList")
    public List<Order> getOrderList(){
        return orderService.list();
    }

    @PostMapping("/saveOrder")
    public Boolean saveOrder(@RequestBody Order order){
        return orderService.save(order);
    }

    @PostMapping("/updateOrder")
    public Boolean updateOrder(@RequestBody Order order){
        return orderService.updateById(order);
    }

    @DeleteMapping("/deleteOrder")
    public Boolean deleteOrder(@RequestBody Order order){
        return orderService.removeById(order.getId());
    }


}
