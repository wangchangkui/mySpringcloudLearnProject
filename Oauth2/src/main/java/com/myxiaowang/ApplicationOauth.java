package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 09:50:00
 */


@EnableEurekaClient
@SpringBootApplication
public class ApplicationOauth {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationOauth.class,args);
    }
}
