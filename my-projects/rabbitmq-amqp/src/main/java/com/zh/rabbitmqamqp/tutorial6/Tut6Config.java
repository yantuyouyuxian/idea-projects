package com.zh.rabbitmqamqp.tutorial6;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/11 22:20
 * @ Description
 */
@Profile("tut6")
@Configuration
public class Tut6Config {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tut6.rpc");
    }

    @Profile("client")
    private static class ClientConfig {

        @Bean
        public Tut6Client client() {
            return new Tut6Client();
        }

    }

    @Profile("server")
    private static class ServerConfig {

        @Bean
        public Queue queue() {
            return new Queue("tut6.rpc.requests");
        }

        @Bean
        public Binding binding(DirectExchange exchange, Queue queue) {
            return BindingBuilder.bind(queue).to(exchange).with("rpc");
        }

        @Bean
        public Tut6Server server() {
            return new Tut6Server();
        }

    }
}
