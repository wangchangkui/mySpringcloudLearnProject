package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 18:33:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperOrderA {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperOrderA.class,args);
    }
}
