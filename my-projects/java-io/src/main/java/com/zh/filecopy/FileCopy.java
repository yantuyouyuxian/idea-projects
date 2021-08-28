package com.zh.filecopy;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Reader;
import java.text.DecimalFormat;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/27 13:57
 * @ Description
 */
public class FileCopy {

    @Test
    public void fileCopy() {
        String oldFile = "D:\\迅雷下载\\abcd.zip";
        String newFile = "D:\\迅雷下载\\abcd_new.zip";

        try (FileInputStream fis = new FileInputStream(oldFile);
             FileOutputStream fos = new FileOutputStream(newFile)) {
            int total = fis.available();
            System.out.println("total = " + total);
            int sum = 0;
            int get;
            double progress = 0;
            byte[] buffer = new byte[1024];
            while ((get = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, get);
                sum += get;
                if (((double) sum / total - progress) > 0.02 || sum == total) {
                    progress = (double) sum / total;
                    System.out.println(new DecimalFormat("#%").format(progress));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
