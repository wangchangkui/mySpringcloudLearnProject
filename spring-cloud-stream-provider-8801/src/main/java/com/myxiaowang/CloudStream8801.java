package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月22日 18:19:00
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStream8801 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStream8801.class,args);
    }
}
