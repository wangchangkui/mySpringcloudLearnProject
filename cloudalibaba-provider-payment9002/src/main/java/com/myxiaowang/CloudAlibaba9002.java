package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月07日 13:12:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibaba9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibaba9002.class, args);
    }
}
