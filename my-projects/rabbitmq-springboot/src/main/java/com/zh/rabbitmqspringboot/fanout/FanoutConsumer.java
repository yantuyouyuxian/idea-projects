package com.zh.rabbitmqspringboot.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/23 23:32
 * @ Description
 */
@Component
public class FanoutConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs", type = ExchangeTypes.FANOUT)//交换机
            )})
    public void testFanout1(String msg) {
        System.out.println("fanout msg 1 " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs", type = ExchangeTypes.FANOUT)//交换机
            )})
    public void testFanout2(String msg) {
        System.out.println("fanout msg 2 " + msg);
    }
}
