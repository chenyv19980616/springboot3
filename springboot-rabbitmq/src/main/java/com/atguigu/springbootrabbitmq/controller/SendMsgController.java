package com.atguigu.springbootrabbitmq.controller;

import com.atguigu.springbootrabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : chenyv
 * @description : 生产者
 * @since :  2024-01-19 14:58:22
 **/
@Slf4j
@RestController
@RequestMapping("/ttl")
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送普通消息
     * @param message
     */
    @GetMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable("message") String message) {
        log.info("当前时间：{},发送一条消息给两个TTL队列：{}", new Date().toString(), message);
        rabbitTemplate.convertAndSend("X", "XA", "消息来自ttl为10s的队列" + message);
        rabbitTemplate.convertAndSend("X", "XB", "消息来自ttl为40s的队列" + message);
    }

    /**
     * 发送TTL消息
     * @param message
     * @param ttlTime
     */
    @GetMapping("/sendExpirationMsg/{message}/{ttlTime}")
    public void sendExpirationMsg(@PathVariable("message") String message, @PathVariable("ttlTime") String ttlTime) {
        log.info("当前时间：{},发送一条时长为：{}毫秒的TTL消息给队列QC：{}", new Date(), ttlTime, message);
        rabbitTemplate.convertAndSend("X", "XC", message, msg -> {
            msg.getMessageProperties().setExpiration(ttlTime);
            return msg;
        });
    }

    /**
     * 发送延迟消息
     * @param message
     * @param ttlTime
     */
    @GetMapping("/sendDelayMsg/{message}/{ttlTime}")
    public void sendDelayMsg(@PathVariable("message") String message, @PathVariable("ttlTime") Integer ttlTime) {
        log.info("当前时间：{},发送一条时长为：{}毫秒的消息给延迟队列delayed.queue：{}", new Date(), ttlTime, message);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE_NAME, DelayedQueueConfig.DELAYED_ROUTING_KEY, message, msg -> {
            msg.getMessageProperties().setDelay(ttlTime);
            return msg;
        });
    }

}
