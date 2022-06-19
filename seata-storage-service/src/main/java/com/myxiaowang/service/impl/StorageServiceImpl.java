package com.myxiaowang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxiaowang.dao.StorageMapper;
import com.myxiaowang.entity.Storage;
import com.myxiaowang.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年06月19日 20:28:00
 */

@Slf4j
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public String deduct(Long productId, Integer count) {
        log.info("查询库存信息");
        Storage storage = getOne(new LambdaQueryWrapper<Storage>().eq(Storage::getProductId, productId));
        log.info("更新库存信息");
        storage.setResidue(storage.getResidue() - count);
        storage.setUsed(storage.getUsed() + count);
        storageMapper.updateById(storage);
        return "success";
    }
}
