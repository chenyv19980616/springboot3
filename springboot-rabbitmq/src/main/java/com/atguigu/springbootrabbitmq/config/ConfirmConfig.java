package com.atguigu.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenyv
 * @since :  2024-01-23 14:18:58
 **/
@Configuration
public class ConfirmConfig {
    /**
     * 交换机
     */
    public static final String CONFIRM_EXCHANGE_NAME = "confirm_exchange";
    /**
     * 队列
     */
    public static final String CONFIRM_QUEUE_NAME = "confirm_queue";
    /**
     *
     */
    public static final String CONFIRM_ROUTING_KEY = "key1";

    /**
     * 声明交换机
     * @return
     */
    @Bean("confirmExchange")
    public DirectExchange confirmExchange() {
        return new DirectExchange(CONFIRM_EXCHANGE_NAME);
    }

    /**
     * 声明队列
     * @return
     */
    @Bean("confirmQueue")
    public Queue confirmQueue() {
        return QueueBuilder.durable(CONFIRM_QUEUE_NAME).build();
    }

    /**
     * 绑定队列到交换机
     * @param confirmExchange
     * @param confirmQueue
     * @return
     */
    @Bean
    public Binding queueBindingExchange(@Qualifier("confirmExchange") DirectExchange confirmExchange,
                                        @Qualifier("confirmQueue") Queue confirmQueue) {
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with(CONFIRM_ROUTING_KEY);

    }
}
