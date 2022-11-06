package com.myxiaowang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxiaowang.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月04日 10:07:00
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
