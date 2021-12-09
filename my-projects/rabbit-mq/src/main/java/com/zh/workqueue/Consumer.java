package com.zh.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/21 19:53
 * @ Description
 */
public class Consumer implements Runnable {

    private final Connection connection;
    private final String queueName;
    private final Integer seconds;
    private String name;

    public Consumer(Connection connection, String queueName, Integer seconds, String name) {
        this.connection = connection;
        this.queueName = queueName;
        this.seconds = seconds;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Channel channel = this.connection.createChannel();
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String msg = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(name + "----[x] Received:" + msg + "。");
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(name + "----[x] Receive Done:" + msg + "。");
                //参数1，确认的消息的标识
                //参数2，是否一次确认多条消息
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            };
            channel.basicQos(4 - seconds);
            channel.queueDeclare("work", true, false, false, null);
            //不自动确认
            channel.basicConsume(this.queueName, false, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
