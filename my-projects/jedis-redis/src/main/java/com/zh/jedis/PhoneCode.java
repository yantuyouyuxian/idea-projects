package com.zh.jedis;

import java.util.Random;

import redis.clients.jedis.Jedis;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/15 15:12
 * @ Description
 */
public class PhoneCode {
    public static void main(String[] args) {
        String code = getCode("13101768915");
        System.out.println(code);
        verify("13101768915", code);
    }

    public static String createCode() {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

    public static String getCode(String phone) {
        Jedis jedis = new Jedis("192.168.159.222", 6379);

        String codeKey = phone + "Code";
        String countKey = phone + "Count";

        String count = jedis.get(countKey);
        if (count == null) {
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("验证码次数用完。");
            jedis.close();
            return null;
        }
        String code = createCode();
        jedis.setex(codeKey, 120, code);
        jedis.close();
        return code;
    }

    public static void verify(String phone, String code) {
        Jedis jedis = new Jedis("192.168.159.222", 6379);
        String codeKey = phone + "Code";
        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code)) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }
        jedis.close();
    }
}
