package com.myxiaowang.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myxiaowang.pojo.Payment;
import com.myxiaowang.service.PaymentFeignService;
import com.myxiaowang.util.Reslut.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 13:50:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/findById/{id}",produces = {"application/json;charset=UTF-8"})
    public ResponseResult<Payment> getOrderInfo( @PathVariable Long id) {
        String forObject = paymentFeignService.findById(id);
        JSONObject jsonObject = JSON.parseObject(forObject);
        if(Objects.isNull(jsonObject.get("data"))){
            return ResponseResult.error("订单不存在");
        }
        Payment data = JSON.parseObject(jsonObject.get("data").toString(), Payment.class);
        return  ResponseResult.success(data);
    }

    @PostMapping(value = "/save",produces = {"application/json;charset=UTF-8"})
    public ResponseResult<String> saveOrder(@RequestBody Payment payment) {
        // 使用openFeign 去调用订单服务，增加订单
        String save = paymentFeignService.save(payment);
        JSONObject jsonObject = JSON.parseObject(save);
        Boolean data = JSON.parseObject(jsonObject.get("data").toString(), Boolean.class);
        if (data.equals(true)) {
            return ResponseResult.success("订单保存成功");
        }
        return ResponseResult.success("订单保存失败");
    }

}
