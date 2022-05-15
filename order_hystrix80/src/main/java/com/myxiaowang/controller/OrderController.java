package com.myxiaowang.controller;


import com.myxiaowang.pojo.Payment;
import com.myxiaowang.service.PaymentFeignServices;
import com.myxiaowang.util.Reslut.ResponseResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 13:50:00
 */
@Slf4j
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "globaleFallBackTo")
public class OrderController {

    @Autowired
    private PaymentFeignServices paymentFeignService;

    @GetMapping(value = "/findById/{id}")
    public ResponseResult<String> getOrderInfo( @PathVariable Long id) {
        String forObject = paymentFeignService.findById(id);
        return  ResponseResult.success(forObject);
    }
    @HystrixCommand(fallbackMethod = "fallBackTo",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    @PostMapping(value = "/save")
    public ResponseResult<String> saveOrder() {
        // 使用openFeign 去调用订单服务，增加订单
        String save;
        save = paymentFeignService.save(new Payment(1L,"999"));
        System.out.println(save);
        return ResponseResult.success(save);
    }

    @HystrixCommand
    @PostMapping(value = "/saveForGlobale")
    public ResponseResult<String> saveOrderTwo() {
        // 使用openFeign 去调用订单服务，增加订单
        String save;
        save = paymentFeignService.save(new Payment(1L,"999"));
        System.out.println(save);
        return ResponseResult.success(save);
    }



    /**
     * 当使用@HystrixComand 指定了返回方法的时候才调用这个方法
     *  例如： @HystrixCommand(fallbackMethod = "fallBackTo",commandProperties = {
     *             &#064;HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
     *     })
     * @return String
     */
    public ResponseResult<String> fallBackTo(){
        log.error("消费者80服务模块请求超时");
        return ResponseResult.error("消费者80服务模块请求超时！");
    }

    public ResponseResult<String> globaleFallBackTo(){
        log.error("全局通用异常返回，消费者80服务模块请求超时");
        return ResponseResult.error("全局通用异常返回，消费者80服务模块请求超时！");
    }

}
