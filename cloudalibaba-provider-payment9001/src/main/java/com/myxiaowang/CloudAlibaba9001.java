package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年06月07日 12:56:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibaba9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibaba9001.class,args);
    }
}
