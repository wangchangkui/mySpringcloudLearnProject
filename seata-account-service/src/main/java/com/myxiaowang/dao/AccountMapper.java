package com.myxiaowang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxiaowang.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:23:00
 */
@Mapper
public interface AccountMapper  extends BaseMapper<Account> {
}
