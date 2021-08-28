package com.zh.print;

import org.junit.Test;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 16:44
 * @ Description
 */
public class PrintStreamWriterTest {

    /**
     * 字节打印流
     */
    @Test
    public void test_1() {
        String path = "d:\\print.txt";
        try (PrintStream ps = System.out) {
            String data = "aabbcc你好";
            ps.write(data.getBytes());
            ps.print('\n');
            ps.println(data);

            System.setOut(new PrintStream(path));
            System.out.println("aaa");
            System.out.println("bbb");
            System.out.println("好好学习");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符打印流
     */
    @Test
    public void test_2() {
        String path ="d:\\printwriter.txt";
//        try(PrintWriter pw = new PrintWriter(System.out)){
        try(PrintWriter pw = new PrintWriter(path)){
            pw.print("好好学习");
            pw.print("\n");
            pw.print("天天向上");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
