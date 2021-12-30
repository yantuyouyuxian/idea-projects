package com.zh.rabbitmqamqp.tutorial1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/8 16:03
 * @ Description
 */
@RabbitListener(queues = "hello")
public class Tut1Receiver {
    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}
