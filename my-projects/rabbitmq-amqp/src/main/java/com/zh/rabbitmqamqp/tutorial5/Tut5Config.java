package com.zh.rabbitmqamqp.tutorial5;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/9 20:34
 * @ Description
 */
@Profile("tut5")
@Configuration
public class Tut5Config {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut5.topic");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Tut5Receiver receiver() {
            return new Tut5Receiver();
        }

        @Bean("tut5Queue1")
        public Queue autoDeleteQueue1() {
            return new Queue("tut5Queue1");
        }

        @Bean("tut5Queue2")
        public Queue autoDeleteQueue2() {
            return new Queue("tut5Queue2");
        }

        @Bean
        public Binding binding1a(TopicExchange topic,
                                 @Qualifier("tut5Queue1") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(topic)
                    .with("*.orange.*");
        }

        @Bean
        public Binding binding1b(TopicExchange topic,
                                 @Qualifier("tut5Queue1") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(topic)
                    .with("*.*.rabbit");
        }

        @Bean
        public Binding binding2a(TopicExchange topic,
                                 @Qualifier("tut5Queue2") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(topic)
                    .with("lazy.#");
        }

    }

    @Profile("sender")
    @Bean
    public Tut5Sender sender() {
        return new Tut5Sender();
    }

}
