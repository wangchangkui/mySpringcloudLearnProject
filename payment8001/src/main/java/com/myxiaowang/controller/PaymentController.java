package com.myxiaowang.controller;

import com.myxiaowang.pojo.Payment;
import com.myxiaowang.service.PaymentService;
import com.myxiaowang.util.Reslut.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 13:23:00
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/findById/{id}")
    public ResponseResult<Payment> findById(@PathVariable("id") Long id) throws InterruptedException {
        log.info("接收到的参数：" + id);
        log.info("执行端口号：" + port);
        return ResponseResult.success( paymentService.getById(id) );
    }

    @PostMapping("/save")
    public ResponseResult<Boolean> save(@RequestBody Payment payment) {
        log.info("接收到的参数：" + payment);
        log.info("执行端口号：" + port);
        return ResponseResult.success( paymentService.save(payment) );
    }
}
