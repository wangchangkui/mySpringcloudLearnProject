package com.myxiaowang.service.impl;

import cn.hutool.core.util.IdUtil;
import com.myxiaowang.service.IMessagerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


/**
 * @author wck
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月22日 18:35:00
 *
 *
 * EnableBinding
 *  * 定义消息的推送管道
 */
@Slf4j
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessagerProvider {

    /**
     * 输出管道
     * 类似与往那个管道推送消息
     */
    @Autowired
    private MessageChannel output;

    @Override
    public String sendMessage(String message) {
        try{
            output.send(MessageBuilder.withPayload(message).build());
            log.info("*****发送消息成功：{} *************", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            return "发送消息成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
