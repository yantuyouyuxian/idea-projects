package com.zh.topics;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zh.utils.RabbitMqUtils;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/23 22:35
 * @ Description
 */
public class ConsumerUpdate {
    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "exchangeTopics";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,exchangeName,"#");
        channel.basicConsume(queue, true,
                (consumerTag, message) -> System.out.println(new String(message.getBody())),
                consumerTag -> {});
    }
}
