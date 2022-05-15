package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 15:34:00
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationB {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationB.class,args);
    }
}
