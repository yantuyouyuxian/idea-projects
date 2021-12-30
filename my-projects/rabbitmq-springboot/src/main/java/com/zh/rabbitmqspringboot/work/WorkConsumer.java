package com.zh.rabbitmqspringboot.work;

import com.rabbitmq.client.Channel;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/23 23:24
 * @ Description
 */
@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String msg) {
        System.out.println("work receive1:" + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String msg) {
        System.out.println("work receive2:" + msg);
    }
}
