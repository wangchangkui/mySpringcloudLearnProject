package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月18日 22:21:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class HystrixOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication.class, args);
    }
}
