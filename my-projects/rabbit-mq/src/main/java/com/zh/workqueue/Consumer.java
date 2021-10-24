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

    public Consumer(Connection connection, String queueName, Integer seconds) {
        this.connection = connection;
        this.queueName = queueName;
        this.seconds = seconds;
    }
    @Override
    public void run() {
        try {
            Channel channel = this.connection.createChannel();
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String msg = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(seconds + "----[x] Received:" + msg + "。");
                //参数1，确认的消息的标识
                //参数2，是否一次确认多条消息
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            };
            //每次获取一条消息
            channel.basicQos(1);
            channel.queueDeclare("work", true, false, false, null);
            //不自动确认
            channel.basicConsume(this.queueName, false, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
