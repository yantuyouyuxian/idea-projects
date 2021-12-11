package com.zh.rabbitmqamqp.manualAck;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/11 23:46
 * @ Description
 */
public class Producer {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange exchange;

    @Autowired
    private Queue queue;

    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000 * 60 * 5, initialDelay = 500)
    public void send() {
        for (int i = 0; i < 10; i++) {
            String message = "Hello World! ---" + count.incrementAndGet();
            template.convertAndSend(exchange.getName(), queue.getName(), message);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}
