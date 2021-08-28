package com.zh.reader;

import org.junit.Test;

import java.io.FileReader;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/27 14:49
 * @ Description
 */
public class FileReaderTest {
    @Test
    public void test() {
        String path = "D:\\test.txt";
        try (FileReader fr = new FileReader(path)) {
//            int c;
//            while ((c = fr.read()) != -1) {
//                System.out.print((char)c);
//            }
            char[] data = new char[128];
            int len;
            while ((len = fr.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
