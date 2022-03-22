package com.zh.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/20 18:07
 * @ Description
 */
public class JedisConnectionFactory {
    private static final JedisPool jedispool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);// 最大连接数
        jedisPoolConfig.setMaxIdle(8);// 最大空闲连接数
        jedisPoolConfig.setMinIdle(0);//
        jedisPoolConfig.setMaxWaitMillis(200);// 没有空闲连接时最大等待连接时间
        jedispool = new JedisPool(jedisPoolConfig, "192.168.159.226", 6379, 1000, "123456");
    }

    public static Jedis getJedis(){
        return jedispool.getResource();
    }
}
