package com.atguigu.rabbitmq.test06;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

/**
 * @author : chenyv
 * @description : 消费者1
 * @since :  2024-01-09 09:59:43
 **/
public class ReceiveLogsDirect02 {

    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMqUtils.getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        channel.queueDeclare("disk", false, false, false, null);

        channel.queueBind("disk", EXCHANGE_NAME, "error");

        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println("ReceiveLogsDirect02 接收到的消息为：" + new String(message.getBody(), StandardCharsets.UTF_8));
        };

        CancelCallback cancelCallback = (consumerTag)->{};

        channel.basicConsume("disk", true, deliverCallback, cancelCallback);
    }
}
