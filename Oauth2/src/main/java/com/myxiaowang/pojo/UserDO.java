package com.myxiaowang.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Myxiaowang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@TableName("uaa_user")
public class UserDO {

    public UserDO() {
    }

    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 密码
     */
    private String nickname;
    /**
     * 手机号
     */
    private String mobilePhone;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 修改人
     */
    private Long editor;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 最后修改时间
     */
    private Date gmtEdit;
}