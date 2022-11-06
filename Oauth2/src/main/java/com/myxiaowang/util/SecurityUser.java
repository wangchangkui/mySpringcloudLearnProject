package com.myxiaowang.util;

import com.myxiaowang.pojo.UserDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 10:08:00
 */
public class SecurityUser extends UserDO implements UserDetails{


    private Collection<SimpleGrantedAuthority> authorities;

    private Boolean nonAccountNonExpired;

    public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getNonAccountNonExpired() {
        return nonAccountNonExpired;
    }

    public void setNonAccountNonExpired(Boolean nonAccountNonExpired) {
        this.nonAccountNonExpired = nonAccountNonExpired;
    }

    public Boolean getNonCredentialsNonExpired() {
        return nonCredentialsNonExpired;
    }

    public void setNonCredentialsNonExpired(Boolean nonCredentialsNonExpired) {
        this.nonCredentialsNonExpired = nonCredentialsNonExpired;
    }

    public Boolean getNonAccountNonLocked() {
        return nonAccountNonLocked;
    }

    public void setNonAccountNonLocked(Boolean nonAccountNonLocked) {
        this.nonAccountNonLocked = nonAccountNonLocked;
    }

    public Boolean getNonEnabled() {
        return nonEnabled;
    }

    public void setNonEnabled(Boolean nonEnabled) {
        this.nonEnabled = nonEnabled;
    }

    private Boolean nonCredentialsNonExpired;

    private Boolean nonAccountNonLocked;

    private Boolean nonEnabled;
    public SecurityUser() {
        super();

    }
    public SecurityUser(UserDO userDO) {
        super(userDO.getId(),userDO.getUsername(),userDO.getPassword(),userDO.getNickname(),userDO.getMobilePhone(),userDO.getStatus(),userDO.getCreator(),userDO.getEditor(),userDO.getGmtCreate(),userDO.getGmtEdit());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return nonAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return nonAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return nonCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return nonEnabled;
    }
}
