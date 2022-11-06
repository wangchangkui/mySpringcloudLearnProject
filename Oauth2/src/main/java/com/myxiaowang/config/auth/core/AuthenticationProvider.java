package com.myxiaowang.config.auth.core;

import com.myxiaowang.util.RedisTemplateUtil;
import com.myxiaowang.util.SecurityUser;
import com.myxiaowang.util.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 11:24:00
 */
@Component

public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    @Autowired
    private UserDetailServiceImpl userDetasService;

    @Autowired
    private PasswordEncoder bcrypt;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取传入的账号密码
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 根据账号查询数据
        SecurityUser userDetails = (SecurityUser) userDetasService.loadUserByUsername(username);
        // 加密比对
        if (bcrypt.matches(password, userDetails.getPassword())) {
            // 设置认证信息
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }
       return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
