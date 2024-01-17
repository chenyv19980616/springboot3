package com.atguigu.rabbitmq.test08;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

/**
 * @author : chenyv
 * @description : 生产者
 * @since :  2024-01-09 14:43:51
 **/
public class Producer {
    /**
     * 普通交换机
     */
    public static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        // 发送死刑消息  设置TTL时间
        // AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().expiration("10000").build();

        for (int i = 1; i <= 10; i++) {
            String message = "info" + i;
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", null, message.getBytes());
        }
    }

}
