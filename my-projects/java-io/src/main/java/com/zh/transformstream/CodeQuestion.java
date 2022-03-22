package com.zh.transformstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 15:45
 * @ Description
 */
public class CodeQuestion {
    @Test
    public void test(){
        String path = "d:\\test.txt";
        //默认utf-8
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String data;
            while ((data = br.readLine()) != null){
                System.out.println(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
