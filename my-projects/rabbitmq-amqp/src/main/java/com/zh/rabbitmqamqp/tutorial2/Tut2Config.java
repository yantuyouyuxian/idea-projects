package com.zh.rabbitmqamqp.tutorial2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/8 16:23
 * @ Description
 */
@Profile("tut2")
@Configuration
public class Tut2Config {

    @Bean
    public Queue hello() {
        return new Queue("tut2 hello queue");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Tut2Receiver receiver1() {
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public Tut2Sender sender() {
        return new Tut2Sender();
    }
}
