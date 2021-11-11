package com.zh.rabbitmqspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/23 23:02
 * @ Description
 */
@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void testHelloWorld() {
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    //workqueue
    @Test
    public void testWork() {
        for (int i = 0; i <10; i++) {
            rabbitTemplate.convertAndSend("work", "hello world " + i);
        }
    }

    //fanout
    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("logs", "", "fanout广播模型");
    }

    //routing
    @Test
    public void testRouting() {
        rabbitTemplate.convertAndSend("direct", "info", "info信息");
        rabbitTemplate.convertAndSend("direct", "error", "error信息");
    }

    //topic
    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend("topic", "user.save", "user.save message");
        rabbitTemplate.convertAndSend("topic", "user.update", "user.update message");
    }
}
