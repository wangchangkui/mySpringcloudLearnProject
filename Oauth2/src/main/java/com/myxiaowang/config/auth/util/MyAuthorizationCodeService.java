package com.myxiaowang.config.auth.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月06日 10:32:00
 */
@Configuration
public class MyAuthorizationCodeService {
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }
}
