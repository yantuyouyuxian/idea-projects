package com.zh.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/25 20:40
 * @ Description
 */
public class FileInputStreamTest {

    public static void main(String[] args) {

    }

    @Test
    public void readTxt() {
        String filePath = "d:\\test.txt";
        try (FileInputStream fis = new FileInputStream(filePath)) {
//            int data;
//            while ((data = fis.read()) != -1) {
//                System.out.print((char) data);
//            }
            byte[] chars = new byte[128];
            int l;
            while ((l = fis.read(chars)) != -1) {
                System.out.println(new String(chars, 0, l));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
