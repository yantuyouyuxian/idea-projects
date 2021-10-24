package com.zh.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.zh.utils.RabbitMqUtils;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/19 21:24
 * @ Description
 */
public class Producer {
    public static final String QUEUE_NAME = "hello";
    @Test
    public void sendMsgTest() throws Exception {

        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //通道绑定队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        channel.basicPublish("", QUEUE_NAME, null, "hello rabbi".getBytes(StandardCharsets.UTF_8));
        //发送消息持久化
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbitmq".getBytes(StandardCharsets.UTF_8));

        RabbitMqUtils.closeRabbitLink(channel, connection);
    }
}
