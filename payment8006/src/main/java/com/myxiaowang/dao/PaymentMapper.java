package com.myxiaowang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxiaowang.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 13:15:00
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
