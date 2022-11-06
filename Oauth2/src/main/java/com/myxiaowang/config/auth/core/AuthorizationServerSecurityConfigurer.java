
package com.myxiaowang.config.auth.core;

import com.myxiaowang.util.JwtTokenEnhancer;
import com.myxiaowang.util.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;


/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 10:20:00
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerSecurityConfigurer extends AuthorizationServerConfigurerAdapter {
    public static final String JWT_PASSWORD = "coder.wang";

    /**
     * 密码加密
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * token存内存
     */
    @Autowired
    @Qualifier("jwtTokenStore")
    private TokenStore tokenStore;

    /**
     * 认证服务
     */
    @Autowired
    private AuthenticationManager authenticationManagerBean;

    /**
     * 账号密码信息认证
     */
    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    /**
     * 转换为token
     */
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    /**
     * 客户端认证存放
     */
    @Autowired
    private ClientDetailsService clientDetailsService;

    /**
     * token额外信息
     */
    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;

    /**
     * 授权码模式下的认证存放位置
     */
    @Autowired
    private AuthorizationCodeServices myAuthorizationCodeServices;


    @Override
    public void configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer security) {
        security.allowFormAuthenticationForClients()
                // 检查token放行权限
                .checkTokenAccess("isAuthenticated()")
                // token请求放行
                .tokenKeyAccess("isAuthenticated()")
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 基于内存的认证客户端信息
        clients.inMemory()
                .withClient("admin")
                .secret(passwordEncoder.encode("admin"))
                .authorizedGrantTypes("authorization_code","password","refresh_token")
                .scopes("all")
                // 授权完成自动跳转
                .redirectUris("http://www.iwck.top");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManagerBean)
                // 这个方法回去调用AuthenticationProvider类的认证用户方法
                .userDetailsService(userDetailServiceImpl)
                .authorizationCodeServices(myAuthorizationCodeServices)
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenServices(tokenService())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);;
    }



    @Bean
    public AuthorizationServerTokenServices tokenService() {
        DefaultTokenServices service = new DefaultTokenServices();
        // 客户端详情服务
        service.setClientDetailsService(clientDetailsService);
        // 支持刷新令牌
        service.setSupportRefreshToken(true);
        // 令牌存储策略
        service.setTokenStore(tokenStore);
        // 令牌默认有效期24小时
        service.setAccessTokenValiditySeconds(3600 * 24);
        // 刷新令牌默认有效期7天
        service.setRefreshTokenValiditySeconds(3600 * 24 * 7);
        // 存储额外的信息
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);
        return service;
    }





}

