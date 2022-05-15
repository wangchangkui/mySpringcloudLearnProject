package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 12:56:00
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplicationA {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationA.class, args);
    }
}
