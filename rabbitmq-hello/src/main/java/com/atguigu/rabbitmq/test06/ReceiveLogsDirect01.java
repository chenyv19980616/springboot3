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
public class ReceiveLogsDirect01 {

    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMqUtils.getChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        channel.queueDeclare("console", false, false, false, null);

        channel.queueBind("console", EXCHANGE_NAME, "info");
        channel.queueBind("console", EXCHANGE_NAME, "warning");

        DeliverCallback deliverCallback = (consumerTag,message)->{
            System.out.println("ReceiveLogsDirect01 接收到的消息为：" + new String(message.getBody(), StandardCharsets.UTF_8));
        };

        CancelCallback cancelCallback = (consumerTag)->{};

        channel.basicConsume("console", true, deliverCallback, cancelCallback);
    }
}
