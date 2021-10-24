package com.zh.topics;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zh.utils.RabbitMqUtils;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/22 14:37
 * @ Description
 */
public class Producer {
    @Test
    public void sendMsg() throws Exception {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //* 匹配一个单词
        //# 匹配0或多个单词
        String exchangeName = "exchangeTopics";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);
        String routingKey = "user.update";
        channel.basicPublish(exchangeName, routingKey, null, ("topics:routingKey:[" + routingKey + "]").getBytes(StandardCharsets.UTF_8));
        RabbitMqUtils.closeRabbitLink(channel, connection);
    }
}
