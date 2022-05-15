package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月18日 20:38:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OpenFeignOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrderApplication.class, args);
    }
}
