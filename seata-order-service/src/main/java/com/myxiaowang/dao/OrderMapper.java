package com.myxiaowang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxiaowang.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月13日 22:34:00
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
