package com.zh.rabbitmqamqp.manualAck;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
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
    private DirectExchange exchange;

    @Autowired
    private Queue queue;

    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000 * 200, initialDelay = 500)
    public void send() {
        for (int i = 0; i < 10; i++) {
            CorrelationData data = new CorrelationData();
            String message = "Hello World! -> " + exchange.getName() + " -> " + queue.getName() + " - " + count.incrementAndGet();
            template.convertAndSend(exchange.getName(), "manual-ack", message, data);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}
