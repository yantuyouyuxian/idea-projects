package com.zh.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.zh.utils.RabbitMqUtils;

import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/21 21:05
 * @ Description
 */
public class Consumer2 {
    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //绑定交换机
        channel.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);
        //临时队列
        String queue = channel.queueDeclare().getQueue();
        //绑定交换机和临时队列
        channel.queueBind(queue, "logs", "");
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String msg = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("[x] Received:" + msg + "。");
        };
        channel.basicConsume(queue, true, deliverCallback, tag -> {
        });
    }
}
