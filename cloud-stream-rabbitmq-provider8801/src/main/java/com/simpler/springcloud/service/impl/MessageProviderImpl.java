package com.simpler.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.simpler.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author simpler
 * @program: cloud2020
 * @description:
 * @create 2020/12/11 11:34
 */
@EnableBinding(Source.class)    //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {

        String serial = IdUtil.simpleUUID();

        output.send(MessageBuilder.withPayload(serial).build());

        log.info("**************serial: " + serial);

        return null;
    }
}
