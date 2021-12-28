package com.zh.springmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/28 0:46
 * @ Description
 */
@SpringBootApplication
@EnableScheduling
public class SpringMailApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMailApplication.class, args);
    }
}
