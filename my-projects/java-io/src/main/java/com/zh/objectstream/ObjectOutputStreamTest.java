package com.zh.objectstream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/27 21:13
 * @ Description
 */
public class ObjectOutputStreamTest {

    @Test
    public void test() {
        String path = "d:\\oos.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeInt(10);
            oos.writeBoolean(true);
            oos.writeChar('A');
            oos.writeChar('寒');
            oos.writeDouble(0.3);
            oos.writeUTF("好好学习");
            oos.writeObject(new Dog("大黄", 22));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Dog implements Serializable {

    private static final long serialVersionUID = -4558163114128720595L;
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
