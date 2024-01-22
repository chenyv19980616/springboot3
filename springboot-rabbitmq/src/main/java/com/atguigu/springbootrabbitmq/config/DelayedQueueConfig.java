package com.atguigu.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenyv
 * @since :  2024-01-22 15:34:24
 **/
@Configuration
public class DelayedQueueConfig {
    /**
     * 队列
     */
    public static final String DELAYED_QUEUE_NAME = "delayed.queue";
    /**
     * 交换机
     */
    public static final String DELAYED_EXCHANGE_NAME = "delayed.exchange";
    /**
     * 路由键
     */
    public static final String DELAYED_ROUTING_KEY = "delayed.routing.key";

    /**
     * 声明交换机
     * @return
     */
    @Bean("delayedExchange")
    public CustomExchange delayedExchange() {
        Map<String,Object> arguments = new HashMap<>();
        arguments.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, arguments);
    }

    /**
     * 声明队列
     * @return
     */
    @Bean("delayedQueue")
    public Queue delayedQueue(){
        return new Queue(DELAYED_QUEUE_NAME);
    }

    /**
     * 绑定延迟队列到延迟交换机
     * @param delayedExchange
     * @param delayedQueue
     * @return
     */
    @Bean
    public Binding delayedQueueBindingDelayedExchange(@Qualifier("delayedExchange") CustomExchange delayedExchange,
                                                      @Qualifier("delayedQueue") Queue delayedQueue){
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();
    }

}
