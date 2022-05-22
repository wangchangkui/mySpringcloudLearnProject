package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月22日 12:19:00
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfig3366 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfig3366.class,args);
    }
}
