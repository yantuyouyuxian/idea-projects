package com.zh.rabbitmqspringboot.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/23 23:15
 * @ Description
 */
@Component//默认持久化，非独占，不自动删除
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("hello handler:" + message);
    }
}
