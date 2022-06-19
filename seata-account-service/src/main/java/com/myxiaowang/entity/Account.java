package com.myxiaowang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:21:00
 */
@Data
@TableName("t_account")
public class Account {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "total")
    private BigDecimal total;

    @TableField(value = "used")
    private BigDecimal used;

    @TableField(value = "residue")
    private BigDecimal residue;

}
