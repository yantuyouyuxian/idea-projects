package com.zh.outputstream;


import org.junit.Test;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/27 11:11
 * @ Description
 */
public class FileOutputStreamTest {

    //自动创建文件
    @Test
    public void test() {
        String path = "D:\\output.txt";
        try (FileOutputStream fos = new FileOutputStream(path,true)) {
            String str_1 = "hello 世界";
            String str_2 = new String(str_1.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            String str_3 = new String(str_2.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            fos.write(str_1.getBytes(StandardCharsets.UTF_8));
            fos.write("\n".getBytes());
            fos.write(str_2.getBytes(StandardCharsets.ISO_8859_1));
            fos.write("\n".getBytes());
            fos.write(str_3.getBytes(StandardCharsets.UTF_8));

            System.out.println(str_1);
            System.out.println(str_2);
            System.out.println(str_3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
