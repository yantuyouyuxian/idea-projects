package com.zh.rabbitmqamqp.manualAck;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import lombok.SneakyThrows;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/11 23:17
 * @ Description
 */
@Profile("manualAck")
@Configuration
public class ManualAckConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("manualAckExchange");
    }

    @Bean
    public Queue queue(){
        return new Queue("manualAckQueue");
    }

    @Bean
    public Binding binding(FanoutExchange exchange,
                           Queue queue){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Consumer consumer(){
        return new Consumer();
    }

    @Bean
    public Producer producer(){
        return new Producer();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory messageListenerContainer() {
        SimpleRabbitListenerContainerFactory container = new SimpleRabbitListenerContainerFactory();
        container.setConnectionFactory(rabbitConnectionFactory());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //限流表示每次消费端拉取一条消息进行消费直到收到确认完成后在拉取下一条
        container.setPrefetchCount(1);
        container.setMessageConverter(new MessageConverter() {
            @Override
            public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
                return new Message(object.toString().getBytes(), messageProperties);
            }

            @SneakyThrows
            @Override
            public Object fromMessage(Message message) throws MessageConversionException {
                return new String(message.getBody(), StandardCharsets.UTF_8);
            }
        });
        return container;
    }

    @Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.159.222");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        return connectionFactory;
    }

    @Profile("manualAck")
    private static class ConfirmListenerConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

        private RabbitTemplate rabbitTemplate;

        @Autowired
        public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
        }

        @PostConstruct
        void init() {
            rabbitTemplate.setConfirmCallback(this);
            rabbitTemplate.setReturnsCallback(this);
        }

        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            //消息发送到路由，true/false
            System.out.println("correlationData: " + correlationData);
            System.out.println("ack: " + ack);
            System.out.println("cause: " + cause);
        }

        @Override
        public void returnedMessage(ReturnedMessage returned) {
            System.out.println("returnedMessage: " + returned);
        }
    }
}
