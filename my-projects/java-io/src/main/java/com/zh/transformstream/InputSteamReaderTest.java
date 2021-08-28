package com.zh.transformstream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 15:43
 * @ Description
 */
public class InputSteamReaderTest {
    @Test
    public void test_1() {
        String path = "d:\\test.txt";
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "GBK");
             BufferedReader br = new BufferedReader(isr)) {
            int c;
            String data;
//            while ((c = isr.read()) != -1) {
//                System.out.print((char) c);
//            }
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_2() {
        String path = "d:\\osw.txt";
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), "GBK");
             BufferedWriter bw = new BufferedWriter(osw)) {
//            osw.write("好好学习");
            bw.write("好好学习");
            bw.newLine();
            bw.write("天天向上");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_3() {
        String path_1 = "d:\\test.txt";
        String path_2 = "d:\\osw.txt";
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(path_1), "GBK");
             OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path_2), StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr);
             BufferedWriter bw = new BufferedWriter(osw)) {
//            int c;
//            while ((c = isr.read()) != -1) {
//                System.out.print((char) c);
//                osw.write(c);
//            }
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
                bw.write(data);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
