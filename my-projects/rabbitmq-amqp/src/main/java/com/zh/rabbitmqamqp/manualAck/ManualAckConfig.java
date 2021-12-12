package com.zh.rabbitmqamqp.manualAck;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
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
    public DirectExchange fanoutExchange(){
        return new DirectExchange("manualAckExchange");
    }

    @Bean
    public Queue queue(){
        return new Queue("manualAckQueue");
    }

    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("manual-ack");
    }

    @Bean
    public Consumer consumer(){
        return new Consumer();
    }

    @Bean
    public Producer producer(){
        return new Producer();
    }

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("correlationData: " + correlationData);
            System.out.println("ack: " + ack);
            System.out.println("cause: " + cause);
        });

        rabbitTemplate.setReturnsCallback(returned -> System.out.println("returnedMessage: " + returned));
    }


    @Bean
    public SimpleRabbitListenerContainerFactory messageListenerContainer(CachingConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory container = new SimpleRabbitListenerContainerFactory();
        container.setConnectionFactory(connectionFactory);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setPrefetchCount(3);
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

    /**
     * 配置连接
     */
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.159.222");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/ems");
        return connectionFactory;
    }
}
