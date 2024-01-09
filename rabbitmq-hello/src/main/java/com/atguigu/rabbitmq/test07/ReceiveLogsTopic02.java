package com.atguigu.rabbitmq.test07;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

/**
 * @author : chenyv
 * @description : 消费者1
 * @since :  2024-01-09 10:45:50
 **/
public class ReceiveLogsTopic02 {

    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String queueName = "Q2";
        channel.queueDeclare(queueName, false, false, false, null);

        channel.queueBind(queueName, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(queueName, EXCHANGE_NAME, "lazy.#");

        DeliverCallback deliverCallback = (consumerTag, message)->{
            System.out.println("ReceiveLogsTopic02 接收到的消息为：" + new String(message.getBody(), StandardCharsets.UTF_8));
            System.out.println("接收队列：" + queueName + "，绑定键：" + message.getEnvelope().getRoutingKey());
        };

        CancelCallback cancelCallback = (consumerTag)->{};

        channel.basicConsume(queueName, true, deliverCallback, cancelCallback);
    }
}
