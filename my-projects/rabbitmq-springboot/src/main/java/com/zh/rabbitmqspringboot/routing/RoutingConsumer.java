package com.zh.rabbitmqspringboot.routing;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/23 23:38
 * @ Description
 */
@Component
public class RoutingConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//临时队列
                    exchange = @Exchange(value = "direct", type = ExchangeTypes.DIRECT),
                    key = {"info"}
            )
    })
    public void receiveInfo(String msg) {
        System.out.println("info:" + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//临时队列
                    exchange = @Exchange(value = "direct", type = ExchangeTypes.DIRECT),
                    key = {"error"}
            )
    })
    public void receiveError(String msg) {
        System.out.println("error:" + msg);
    }
}
