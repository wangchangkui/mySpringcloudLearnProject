package com.myxiaowang.service;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年05月22日 18:34:00
 */
public interface IMessagerProvider {

    /**
     * 发送消息
     * @param message 消息内容
     * @return 发送结果
     */
    String sendMessage(String message);

}
