package com.zh.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zh.utils.RabbitMqUtils;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/21 20:59
 * @ Description
 */
public class Producer {
    @Test
    public void produce() throws Exception {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        //参数1：交换机名称
        //参数2：交换机类型
        channel.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);
        //发送消息给交换机
        channel.basicPublish("logs", "", null, "logs fanout".getBytes(StandardCharsets.UTF_8));
    }
}
