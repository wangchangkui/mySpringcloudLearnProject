package com.myxiaowang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxiaowang.entity.Storage;


/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:25:00
 */
public interface StorageService extends IService<Storage>  {

    /**
     * 减少库存
     * @param productId 减少库存的商品id
     * @param count 减少的数量
     * @return 操作结果
     */
    String deduct(Long productId, Integer count);
}

