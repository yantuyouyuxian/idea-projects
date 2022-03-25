package com.zh.redis_template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/24 23:29
 * @ Description
 */
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testString(){
        redisTemplate.opsForValue().set("我的名字","张寒");
        System.out.println(redisTemplate.opsForValue().get("我的名字"));
    }

}
