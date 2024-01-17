package com.atguigu.rabbitmq.test08;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenyv
 * @description : 消费者1
 * @since :  2024-01-09 14:21:12
 **/
public class Consumer01 {

    /**
     * 普通交换机
     */
    public static final String NORMAL_EXCHANGE = "normal_exchange";
    /**
     * 死信交换机
     */
    public static final String DEAD_EXCHANGE = "dead_exchange";
    /**
     * 普通队列
     */
    public static final String NORMAL_QUEUE = "normal_queue";
    /**
     * 死信队列
     */
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        // 声明普通交换机
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        // 声明死信交换机
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);

        // 声明普通队列
        Map<String, Object> arguments = new HashMap<>();
        // 设置消息过期时间
        // arguments.put("x-message-ttl", 10000);
        // 设置死信交换机
        arguments.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        // 设置死信Routing-key
        arguments.put("x-dead-letter-routing-key", "lisi");

        // 声明普通队列
        channel.queueDeclare(NORMAL_QUEUE, false, false, false, arguments);
        // 声明死信队列
        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);

        // 绑定普通交换机和普通队列
        channel.queueBind(NORMAL_QUEUE, NORMAL_EXCHANGE, "zhangsan");
        // 绑定死信交换机和死信队列
        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "lisi");

        System.out.println("Consumer01 等待接收消息...");

        DeliverCallback deliverCallback = (consumerTag, message)->{
            System.out.println("Consumer01 接收到的消息为：" + new String(message.getBody(), StandardCharsets.UTF_8));
        };
        channel.basicConsume(NORMAL_QUEUE, true, deliverCallback, consumerTag -> {});
    }

}
