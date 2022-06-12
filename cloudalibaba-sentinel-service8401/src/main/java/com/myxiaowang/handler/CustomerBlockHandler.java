package com.myxiaowang.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author wck
 * @version 1.0.0
 * @Description 用户自定义的限流逻辑
 * @createTime 2022年06月12日 15:57:00
 */

public class CustomerBlockHandler {
    public static String errorHandler1(BlockException e) {
        return "用户自定义限流逻辑1";
    }

    public static String errorHandler2(BlockException e) {
        return "用户自定义限流逻辑2";
    }
}
