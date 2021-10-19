package com.zh.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/19 21:24
 * @ Description
 */
public class Producer {
    private static final String IP_ADD = "192.168.159.222";
    private static final String VHOST_NAME = "/ems";
    public static final String QUEUE_NAME = "HELLO";
    public static final String ACCOUNT = "admin";
    public static final String PASSWORD = "123456";

    @Test
    public void sendMsgTest() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADD);
//        factory.setPort(5672);
        factory.setUsername(ACCOUNT);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VHOST_NAME);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //通道绑定队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicPublish("", QUEUE_NAME, null, "hello rabbitmq".getBytes(StandardCharsets.UTF_8));
        channel.close();
        connection.close();
    }
}
