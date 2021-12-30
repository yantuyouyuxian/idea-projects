package com.zh.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zh.utils.RabbitMqUtils;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/22 14:29
 * @ Description
 */
public class ConsumerAll {

    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs.direct", BuiltinExchangeType.DIRECT);

        String queue = channel.queueDeclare().getQueue();

        channel.queueBind(queue, "logs.direct", "info");
        channel.queueBind(queue, "logs.direct", "error");

        channel.basicConsume(queue, true,
                (consumerTag, message) -> System.out.println(new String(message.getBody())),
                consumerTag -> {
                });

    }
}
