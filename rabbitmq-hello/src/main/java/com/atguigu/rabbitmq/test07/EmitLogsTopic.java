package com.atguigu.rabbitmq.test07;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenyv
 * @description : 生产者
 * @since :  2024-01-09 11:01:15
 **/
public class EmitLogsTopic {

    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        Map<String, String> bindMap = new HashMap<>();
        bindMap.put("quick.orange.rabbit", "Q1,Q2");
        bindMap.put("lazy.orange.elephant", "Q1,Q2");
        bindMap.put("quick.orange.fox", "Q1");
        bindMap.put("lazy.brown.fox", "Q2");
        bindMap.put("lazy.pink.rabbit", "Q2");
        bindMap.put("quick.brown.fox", "丢弃");
        bindMap.put("quick.orange.male.rabbit", "丢弃");
        bindMap.put("lazy.orange.male.rabbit", "Q2");
        for (Map.Entry<String, String> entry : bindMap.entrySet()) {
            String routingKey = entry.getKey();
            String message = entry.getValue();
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }
    }
}
