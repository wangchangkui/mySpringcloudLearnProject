package com.myxiaowang.config.auth.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月06日 10:15:00
 */
@Configuration
public class MyClientDetailsService {
    @Autowired
    private DataSource dataSource;

    /**
     * 客户端基于数据库认证
     * @return jdbcClientDetailsService
     */
    @Bean
    @Qualifier("jdbcClientDetailsService")
    public org.springframework.security.oauth2.provider.ClientDetailsService jdbcClientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }


    /**
     * 客户端id基于内存认证
     * @return MyClientDetailsService
     */
    @Bean
    @Qualifier("inMemoryDetailsService")
    public org.springframework.security.oauth2.provider.ClientDetailsService inMemoryDetailsService() {
        return new InMemoryClientDetailsService();
    }

}
