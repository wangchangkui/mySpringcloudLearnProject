package com.myxiaowang.controller;

import cn.hutool.core.util.IdUtil;
import com.myxiaowang.pojo.Payment;
import com.myxiaowang.util.Reslut.ResponseResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
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


    @GetMapping("/findById/{id}")
    public ResponseResult<String> findById(@PathVariable("id") Long id) throws InterruptedException {
        log.info("接收到的参数：" + id);
        log.info("线程休眠3秒");
        Thread.sleep(3000);
        return ResponseResult.success("Hystrix:"+Thread.currentThread().getName()+"测试，请求ID"+id);
    }

    @HystrixCommand(fallbackMethod = "fallBackTo",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="6000")
    })
    @PostMapping("/save")
    public ResponseResult<String> save(@RequestBody Payment payment) throws InterruptedException {
        System.out.println(payment);
        log.info("延迟3000秒");
        Thread.sleep(3000);
        return ResponseResult.success( "Hystrix延迟1秒操作" );
    }


    /**
     * 服务降级给客户的处理
     * @return string
     */
    public ResponseResult<String> fallBackTo(Payment payment){
        log.info("生产者请求超时了！！");
        System.out.println(payment);
        return ResponseResult.error("请求超时，无法完成请求");
    }


    /**
     * 服务熔断的操作
     * @return 操作
     */

    @HystrixCommand(fallbackMethod = "breaker",commandProperties = {
            // 开启服务熔断
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            // 请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            // 时间窗口期
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            // 失败率达到多少百分比 然后失败
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
            // 更多参数查看 HystrixCommandProperties
    })
    @GetMapping("/breaker/{id}")
    public ResponseResult<String> paymentBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("id不能小于0");
        }
        String s = IdUtil.simpleUUID();
        return ResponseResult.success("返回特殊id"+s);
    }

    public ResponseResult<String> breaker(Integer id){
        log.error("消费服务方的服务熔断");
        return ResponseResult.error("8001服务出现了问题，请稍后再试");
    }
}
