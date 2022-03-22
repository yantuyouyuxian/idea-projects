package com.zh.buffered;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/27 16:03
 * @ Description
 */
public class BufferedReaderTest {
    @Test
    public void test() {
        String path = "D:\\test.txt";
        String des = "D:\\des.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path));
             BufferedWriter bw = new BufferedWriter(new FileWriter(des, true))) {
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
