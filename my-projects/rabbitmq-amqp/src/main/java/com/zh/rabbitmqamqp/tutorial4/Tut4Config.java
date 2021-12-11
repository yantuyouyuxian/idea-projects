package com.zh.rabbitmqamqp.tutorial4;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/9 20:17
 * @ Description
 */
@Profile("tut4")
@Configuration
public class Tut4Config {

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("tut4.direct");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean("tut4Queue1")
        public Queue autoDeleteQueue1() {
            return new Queue("tut4Queue1");
        }

        @Bean("tut4Queue2")
        public Queue autoDeleteQueue2() {
            return new Queue("tut4Queue2");
        }

        @Bean
        public Binding binding1a(DirectExchange direct,
                                 @Qualifier("tut4Queue1") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(direct)
                    .with("orange");
        }

        @Bean
        public Binding binding1b(DirectExchange direct,
                                 @Qualifier("tut4Queue1") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(direct)
                    .with("black");
        }

        @Bean
        public Binding binding2a(DirectExchange direct,
                                 @Qualifier("tut4Queue2") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(direct)
                    .with("green");
        }

        @Bean
        public Binding binding2b(DirectExchange direct,
                                 @Qualifier("tut4Queue2")Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(direct)
                    .with("black");
        }

        @Bean
        public Tut4Receiver receiver() {
            return new Tut4Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Tut4Sender sender() {
        return new Tut4Sender();
    }
}
