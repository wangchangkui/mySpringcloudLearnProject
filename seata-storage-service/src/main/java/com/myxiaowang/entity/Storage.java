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
 * @createTime 2022年06月19日 20:25:00
 */
@Data
@TableName("t_storage")
public class Storage {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "product_id")
    private String productId;

    @TableField(value = "total")
    private Integer total;

    @TableField(value = "used")
    private Integer used;

    @TableField(value = "residue")
    private Integer residue;
}
