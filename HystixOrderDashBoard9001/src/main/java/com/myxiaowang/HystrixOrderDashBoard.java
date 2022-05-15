package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月14日 16:32:00
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixOrderDashBoard {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderDashBoard.class,args);
    }
}
