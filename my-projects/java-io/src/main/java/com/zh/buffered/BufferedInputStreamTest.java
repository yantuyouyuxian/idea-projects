package com.zh.buffered;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/27 16:33
 * @ Description
 */
public class BufferedInputStreamTest {
    @Test
    public void test() {
        String file1 = "D:\\迅雷下载\\abcd.zip";
        String file2 = "D:\\abcd.zip";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file1));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2))) {
            int l;
            byte[] data = new byte[1024];
            while ((l = bis.read(data)) != -1) {
                bos.write(data, 0, l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
