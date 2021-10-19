package com.zh.helloworld;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/19 21:40
 * @ Description
 */
public class Consumer {
    //队列名称
    private static final String IP_ADD = "192.168.159.222";
    private static final String VHOST_NAME = "/ems";
    public static final String QUEUE_NAME = "HELLO";
    public static final String ACCOUNT = "admin";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADD);
//        factory.setPort(5672);
        factory.setUsername(ACCOUNT);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VHOST_NAME);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //绑定队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
            }
        });
    }


}
