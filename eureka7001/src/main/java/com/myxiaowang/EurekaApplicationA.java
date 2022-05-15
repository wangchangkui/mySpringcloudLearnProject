package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 14:56:00
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationA {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationA.class,args);
    }
}
