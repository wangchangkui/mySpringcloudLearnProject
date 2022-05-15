package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月14日 17:17:00
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudGetaway {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGetaway.class,args);
    }
}
