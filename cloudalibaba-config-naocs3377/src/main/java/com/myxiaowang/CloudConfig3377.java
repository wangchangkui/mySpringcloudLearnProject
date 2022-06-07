package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年06月07日 13:45:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConfig3377 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig3377.class, args);
    }
}
