package com.atguigu.springbootrabbitmq.consumer;

import com.atguigu.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author : chenyv
 * @since :  2024-01-24 14:35:36
 **/
@Slf4j
@Component
public class WaringConsumer {

    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE_NAME)
    public void receiveWarningMessage(Message message) {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.error("报警发现不可路由消息：{}", msg);
    }
}
