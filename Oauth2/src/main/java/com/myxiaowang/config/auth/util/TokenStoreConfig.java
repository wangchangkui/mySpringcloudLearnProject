package com.myxiaowang.config.auth.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

import static com.myxiaowang.config.auth.core.AuthorizationServerSecurityConfigurer.JWT_PASSWORD;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 15:10:00
 */
@Configuration
public class TokenStoreConfig {

    @Bean
    @Qualifier("jwtTokenStore")
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean("imMemory")
    public TokenStore memoryTokenStore(){
        return new InMemoryTokenStore();
    }


    @Bean("myJwt")
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPair());
        jwtAccessTokenConverter.setSigningKey(JWT_PASSWORD);
        return jwtAccessTokenConverter;
    }

    @Bean
    public KeyPair keyPair() {
        char[] passChars = JWT_PASSWORD.toCharArray();
        // 从classpath下的证书中获取秘钥对
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), passChars);
        return keyStoreKeyFactory.getKeyPair("small-tools", passChars);
    }

}
