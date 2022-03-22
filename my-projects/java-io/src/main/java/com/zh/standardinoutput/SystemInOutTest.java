package com.zh.standardinoutput;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 15:17
 * @ Description
 */
public class SystemInOutTest {
    @Test
    public void test() {
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
    }
}
