package com.myxiaowang.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxiaowang.mapper.UserMapper;
import com.myxiaowang.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 10:04:00
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDO userDO = userMapper.selectOne(new QueryWrapper<UserDO>().eq("username", s));
        if (Objects.isNull(userDO)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 获取用户当前的状态
        SecurityUser securityUser = new SecurityUser(userDO);
        // todo 权限没细化
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority user = new SimpleGrantedAuthority("User");
        simpleGrantedAuthorities.add(user);
        securityUser.setAuthorities(simpleGrantedAuthorities);
        securityUser.setNonEnabled(false);
        securityUser.setNonAccountNonLocked(false);
        securityUser.setNonAccountNonExpired(false);
        securityUser.setNonCredentialsNonExpired(false);
        if (securityUser.isEnabled()) {
            throw new DisabledException("账号被禁用");
        } else if (securityUser.isAccountNonLocked()) {
            throw new LockedException("账号被锁定");
        } else if (securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException("账号已过期");
        } else if (securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("授权已过期");
        }
        return securityUser;
    }
}
