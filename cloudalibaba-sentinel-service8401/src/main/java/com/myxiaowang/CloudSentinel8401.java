package com.myxiaowang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 * @author Myxiaowang
 */

@EnableDiscoveryClient
@SpringBootApplication
public class CloudSentinel8401
{
    public static void main( String[] args )
    {
        SpringApplication.run(CloudSentinel8401.class, args);
    }
}
