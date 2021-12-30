package com.zh.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zh.utils.RabbitMqUtils;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/22 14:18
 * @ Description
 */
public class Producer {

    @Test
    public void sendMsg() throws Exception {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs.direct", BuiltinExchangeType.DIRECT);
        //发送指定交换机指定路由的消息
        String routingKey = "warn";
        channel.basicPublish("logs.direct", routingKey, null, (routingKey + "消息").getBytes(StandardCharsets.UTF_8));
        RabbitMqUtils.closeRabbitLink(channel, connection);
    }
}
