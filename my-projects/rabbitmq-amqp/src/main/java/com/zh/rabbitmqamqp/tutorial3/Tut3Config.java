package com.zh.rabbitmqamqp.tutorial3;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/9 16:36
 * @ Description
 */
@Profile("tut3")
@Configuration
public class Tut3Config {

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("tut.fanout exchange");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean("tut3queue1")
        public Queue autoDeleteQueue1() {
//            return new AnonymousQueue();
            return new Queue("tut3queue1");
        }

        @Bean("tut3queue2")
        public Queue autoDeleteQueue2() {
//            return new AnonymousQueue();
            return new Queue("tut3queue2");
        }

        @Bean
        public Binding binding1(FanoutExchange fanout,
                                @Qualifier("tut3queue1") Queue queue1) {
            return BindingBuilder.bind(queue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout,
                                @Qualifier("tut3queue2") Queue queue2) {
            return BindingBuilder.bind(queue2).to(fanout);
        }

        @Bean
        public Tut3Receiver receiver() {
            return new Tut3Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Tut3Sender sender() {
        return new Tut3Sender();
    }
}
