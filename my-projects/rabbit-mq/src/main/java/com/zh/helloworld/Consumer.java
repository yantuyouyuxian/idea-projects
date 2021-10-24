package com.zh.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.zh.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/19 21:40
 * @ Description
 */
public class Consumer {
    //队列名称
    public static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //绑定队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String msg = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("[x] Received:" + msg + "。");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }

}
