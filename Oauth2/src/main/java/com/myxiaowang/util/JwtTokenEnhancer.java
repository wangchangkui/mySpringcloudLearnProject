package com.myxiaowang.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxiaowang.mapper.UserMapper;
import com.myxiaowang.pojo.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * JWT内容增强器
 * Created by zyx on 2022/5/2
 */
@Component
@Slf4j
public class JwtTokenEnhancer implements TokenEnhancer {


    @Autowired
    private UserMapper userMapper;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String clientId = authentication.getOAuth2Request().getClientId();
        SecurityUser securityUser;
        try {
            securityUser = (SecurityUser) authentication.getPrincipal();
        } catch (Exception e) {
            // 刷新token时，authentication.getPrincipal只能返回username，此时需要重查数据库
            log.info("===> JwtTokenEnhancer error: {}", e.getMessage());
            UserDO user = userMapper.selectOne(new QueryWrapper<UserDO>().eq("username", authentication.getName()));
            if (Objects.isNull(user)) {
                throw new UsernameNotFoundException("用户不存在");
            }
            securityUser = new SecurityUser(user);
        }
        Map<String, Object> info = new HashMap<>();
        // 把用户信息设置到JWT中
        info.put("clientId", clientId);
        info.put("uid", String.valueOf(securityUser.getId()));
        info.put("username", securityUser.getUsername());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
