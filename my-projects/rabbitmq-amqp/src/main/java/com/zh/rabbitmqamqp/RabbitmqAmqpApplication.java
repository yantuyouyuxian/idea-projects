package com.zh.rabbitmqamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/8 15:55
 * @ Description
 */
@SpringBootApplication
@EnableScheduling
public class RabbitmqAmqpApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqAmqpApplication.class, args);
    }
}
