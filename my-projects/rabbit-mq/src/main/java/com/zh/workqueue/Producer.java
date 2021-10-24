package com.zh.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.zh.utils.RabbitMqUtils;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/21 19:44
 * @ Description
 */
public class Producer {

    @Test
    public void produceMsg() throws IOException, TimeoutException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work", true, false, false, null);
        for (int i = 1; i <= 10; i++) {
            channel.basicPublish("", "work", MessageProperties.PERSISTENT_TEXT_PLAIN, ("第" + i + "条消息").getBytes(StandardCharsets.UTF_8));
        }
        RabbitMqUtils.closeRabbitLink(channel, connection);
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Thread consumer1 = new Thread(new Consumer(RabbitMqUtils.getConnection(), "work", 1));
        consumer1.start();
        Thread consumer2 = new Thread(new Consumer(RabbitMqUtils.getConnection(), "work", 3));
        consumer2.start();
    }
}
