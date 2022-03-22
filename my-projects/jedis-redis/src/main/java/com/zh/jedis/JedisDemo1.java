package com.zh.jedis;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/14 20:48
 * @ Description
 */
public class JedisDemo1 {
    public static void main(String[] args) {

        //建立连接
        Jedis jedis = new Jedis("192.168.159.222", 6379);
        // 设置密码
        jedis.auth("123456");
        // 选择库
        jedis.select(0);

        System.out.println(jedis.ping());
    }

    @Test
    public void test_1() {
        Jedis jedis = new Jedis("192.168.159.222", 6379);
        jedis.flushAll();

        jedis.set("key1", "value1");

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key + " - " + jedis.get(key));
        }

        //string
        jedis.mset("k1", "v1", "k2", "v2");
        System.out.println(jedis.mget("k1", "k2"));

        //list
        jedis.lpush("list1", "aaa", "bbb", "ccc");
        System.out.println(jedis.lrange("list1", 0, -1));

        //set
        jedis.sadd("set1", "a", "b", "c", "a");
        System.out.println(jedis.smembers("set1"));

        //hash
//        jedis.hset("hash1","name","zhangSan");
        jedis.hset("hash1", new HashMap<String, String>() {
            private static final long serialVersionUID = 2848049340793048615L;

            {
                put("name", "zhangSan");
                put("age", "12");
                put("city", "beijing");
            }
        });
        System.out.println(jedis.hgetAll("hash1"));

        //zset
//        jedis.zadd("zset1", 100d, "A");
        jedis.zadd("zset1", new HashMap<String, Double>() {
            private static final long serialVersionUID = 6269455497125005153L;

            {
                put("A", 90d);
                put("B", 80d);
                put("C", 70d);
            }
        });
        System.out.println(jedis.zrange("zset1", 0, -1));
    }

}
