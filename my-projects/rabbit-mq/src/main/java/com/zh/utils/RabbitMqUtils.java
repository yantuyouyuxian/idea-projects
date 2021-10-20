package com.zh.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ Author       zhangHan
 * @ Date         2021/10/20 23:27
 * @ Description
 */
public class RabbitMqUtils {
    //    private static final String IP_ADD = "192.168.159.222";
    private static final String IP_ADD = "192.168.19.10";
    private static final String VHOST_NAME = "/ems";
    public static final String QUEUE_NAME = "HELLO";
    public static final String ACCOUNT = "admin";
    public static final String PASSWORD = "123456";
    private static final ConnectionFactory factory;

    static {
        factory = new ConnectionFactory();
        factory.setHost(IP_ADD);
//        factory.setPort(5672);
        factory.setUsername(ACCOUNT);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VHOST_NAME);
    }
    public static Connection getConnection() throws IOException, TimeoutException {
        return factory.newConnection();
    }

    public static void closeRabbitLink(Channel channel, Connection connection) {
        try {
            if (channel != null) channel.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
