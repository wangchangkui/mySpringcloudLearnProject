package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月13日 21:42:00
 */

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class SeataStorageService9502 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService9502.class, args);
    }
}
