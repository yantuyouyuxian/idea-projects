package com.zh.objectstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 14:48
 * @ Description
 */
public class ObjectInputStreamTest {
    @Test
    public void test() {
        String path = "D:\\oos.dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readChar());
            System.out.println(ois.readChar());
            System.out.println(ois.readDouble());
            System.out.println(ois.readUTF());
            System.out.println(ois.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
