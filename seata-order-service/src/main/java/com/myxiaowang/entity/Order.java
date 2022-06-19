package com.myxiaowang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月13日 22:32:00
 */
@Data
@TableName("t_order")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "user_id")
    private Long userId;
    @TableField(value = "product_id")
    private Long productId;
    @TableField(value = "count")
    private Integer count;
    @TableField(value = "money")
    private Double money;
    @TableField(value = "status")
    private Integer status;
}
