package com.zh.jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import redis.clients.jedis.Jedis;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/20 15:24
 * @ Description
 */
public class JedisClientTest {

    private Jedis jedis;

    @BeforeEach
    public void setup() {
        //建立连接
        jedis = new Jedis("192.168.159.226", 6379);
        // 设置密码
        jedis.auth("123456");
        // 选择库
        jedis.select(0);
        System.out.println(jedis.ping());
    }

    @AfterEach
    public void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }


    @Test
    public void testString() {
        jedis.set("name", "ma dong mei");
        System.out.println(jedis.get("name"));
    }

    @Test
    public void testHash() {
        jedis.hset("user:1", "name", "li si");
        System.out.println(jedis.hget("user:1", "name"));

        jedis.hset("user:2", new HashMap<String, String>() {
            private static final long serialVersionUID = 7758113090105188613L;

            {
                put("name", "liming");
                put("age", "19");
                put("gender", "man");
            }
        });
        System.out.println(jedis.hgetAll("user:2"));
    }


}
