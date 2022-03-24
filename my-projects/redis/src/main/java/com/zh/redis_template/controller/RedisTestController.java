package com.zh.redis_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/15 16:03
 * @ Description
 */
@RestController
@RequestMapping("/redis-test")
public class RedisTestController {

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/testLock")
    public void testLock() {
        String uuid = UUID.randomUUID().toString();
        //1获取锁，setne
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 30, TimeUnit.MILLISECONDS);
        //2获取锁成功、查询num的值
        if (lock) {
            Object value = redisTemplate.opsForValue().get("num");
            //2.1判断num为空return
            if (StringUtils.isEmpty(value)) {
                return;
            }
            //2.2有值就转成成int
            int num = Integer.parseInt(value + "");
            //2.3把redis的num加1
            redisTemplate.opsForValue().set("num", ++num);
            if (uuid.equals((String) redisTemplate.opsForValue().get("lock"))) {
                //2.4释放锁，del
                redisTemplate.delete("lock");
            }
        } else {
            //3获取锁失败、每隔0.1秒再获取
            try {
                Thread.sleep(100);
                testLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @GetMapping("/getName")
    public String testFunction() {
        return (String) redisTemplate.opsForValue().get("name");
    }

    @GetMapping("/setName")
    public void setName() {
        redisTemplate.opsForValue().set("name", "zhangSan" + LocalDateTime.now());
    }
}
