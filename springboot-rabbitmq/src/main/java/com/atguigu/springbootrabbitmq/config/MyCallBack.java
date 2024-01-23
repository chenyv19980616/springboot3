package com.atguigu.springbootrabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author : chenyv
 * @since :  2024-01-23 14:46:05
 **/
@Slf4j
@Component
public class MyCallBack implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 交换机确认回调方法
     * @param correlationData 保存回调消息的id及相关信息
     * @param ack 交换机是否接到消息
     * @param cause 原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData != null ? correlationData.getId() : "";
        if (ack) {
            log.info("交换机收到id为：{}，的消息", id);
        } else {
            log.info("交换机没有收到id为：{}，的消息。原因：{}", id, cause);
        }
    }

    /**
     * 将消息传递过程中不可到达目的地的消息返回给生产者
     * @param returned 消息返回信息
     */
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.error("消息：{}，被交换机：{}退回，退回原因：{}，路由key：{}",
                new String(returned.getMessage().getBody()),
                returned.getExchange(),
                returned.getReplyText(),
                returned.getRoutingKey());
    }
}
