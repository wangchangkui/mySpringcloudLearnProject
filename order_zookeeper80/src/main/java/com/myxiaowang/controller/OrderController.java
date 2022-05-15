package com.myxiaowang.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myxiaowang.pojo.Payment;
import com.myxiaowang.util.Reslut.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @Value("${request.url}")
    private String url;

    @GetMapping("/getOrder/{id}")
    public ResponseResult<Payment> getOrderInfo( @PathVariable Integer id) {
        String forObject = restTemplate.getForObject(url + "/payment/findById/" + id, String.class);
        JSONObject jsonObject = JSON.parseObject(forObject);
        if(Objects.isNull(jsonObject.get("data"))){
            return ResponseResult.error("订单不存在");
        }
        Payment data = JSON.parseObject(jsonObject.get("data").toString(), Payment.class);
        return  ResponseResult.success(data);
    }

    @PostMapping("/create")
    public ResponseResult<String> saveOrder(@RequestBody Payment payment) {
        // 使用restTemplate 去调用订单服务，增加订单
        String forObject = restTemplate.postForObject(url + "/payment/save", payment, String.class);
        JSONObject jsonObject = JSON.parseObject(forObject);
        Boolean data = JSON.parseObject(jsonObject.get("data").toString(), Boolean.class);
        if (data.equals(true)) {
            return ResponseResult.success("订单保存成功");
        }
        return ResponseResult.success("订单保存失败");
    }
}
