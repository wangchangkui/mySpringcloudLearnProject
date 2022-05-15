package com.myxiaowang.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月15日 12:38:00
 */
@Slf4j
@Component
public class GlobaleFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("第一个请求过滤器");
        log.info("请求地址:"+exchange.getRequest().getURI());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 加载过滤器的顺序，数值越小 先加载
        return 0;
    }
}
