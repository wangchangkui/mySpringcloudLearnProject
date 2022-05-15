package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月15日 19:55:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfig {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig.class,args);
    }
}
