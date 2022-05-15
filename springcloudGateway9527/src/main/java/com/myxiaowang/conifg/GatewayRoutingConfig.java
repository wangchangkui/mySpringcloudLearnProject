package com.myxiaowang.conifg;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月14日 17:41:00
 */
@Configuration
public class GatewayRoutingConfig {


    @Bean
    public RouteLocator getRoute(RouteLocatorBuilder route){
       return  route.routes().route("CLOUD-PAYMENT-HYSTRIX-ORDER",s-> s.path("/order/findById/**").uri("http://localhost:80/order/findById/**")).build();
    }
}
