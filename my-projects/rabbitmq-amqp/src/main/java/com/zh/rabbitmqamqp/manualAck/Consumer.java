package com.zh.rabbitmqamqp.manualAck;


import com.rabbitmq.client.Channel;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/11 23:33
 * @ Description
 */
public class Consumer {
    @RabbitListener(queues = "manualAckQueue",containerFactory = "messageListenerContainer")
    public void processMessage(Channel channel, Message message) throws IOException {
        try{
            //签收消息
            System.out.println("---收到消息："+ new String(message.getBody(), StandardCharsets.UTF_8));
            Thread.sleep(3000);
            System.out.println("---签收消息: "+ new String(message.getBody(), StandardCharsets.UTF_8));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            System.out.println("---签收消息异常");
            //处理抛出异常，如果重新把消息放回队列则requeue设置为true否则设置为false
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }

    }


}
