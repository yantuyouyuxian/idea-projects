package com.zh.writer;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/27 14:50
 * @ Description
 */
public class FileWriterTest {

    @Test
    public void test() {
        String path = "d:\\filewritertest.txt";
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write("好好学习");
            fw.write(new char[]{'a', 'b', '我'});
            fw.write("天天向上".toCharArray(), 0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
