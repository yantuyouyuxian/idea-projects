package com.zh.redis_template;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.redis_template.api.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/24 23:29
 * @ Description
 */
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("我的名字", "张寒");
        System.out.println(redisTemplate.opsForValue().get("我的名字"));
    }

    @Test
    void testSerialize() {
        redisTemplate.opsForValue().set("user:1", new User("张三", 19));
        User o = (User) redisTemplate.opsForValue().get("user:1");
        System.out.println(o);
    }

    @Test
    void testStringTemplate() {
        stringRedisTemplate.opsForValue().set("我的名字", "张寒");
        System.out.println(stringRedisTemplate.opsForValue().get("我的名字"));
    }

    @Test
    void testStringTemplateObject() throws JsonProcessingException {
        User user = new User("李四", 33);
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("user:lisi", userJson);
        String readStr = stringRedisTemplate.opsForValue().get("user:lisi");
        User readUser = mapper.readValue(readStr, User.class);
        System.out.println(readUser);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:hash", "name", "hash");
        stringRedisTemplate.opsForHash().put("user:hash", "length", "2");

        stringRedisTemplate.opsForHash().entries("user:hash").forEach((k, v) -> {
            System.out.println("k:" + k + ",v:" + v);
        });
    }

}
