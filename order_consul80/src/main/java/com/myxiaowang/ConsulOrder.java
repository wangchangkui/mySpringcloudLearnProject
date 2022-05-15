package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 13:44:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulOrder {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrder.class,args);
    }
}
