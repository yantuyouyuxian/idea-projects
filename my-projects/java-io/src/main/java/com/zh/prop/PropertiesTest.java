package com.zh.prop;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 17:21
 * @ Description
 */
public class PropertiesTest {
    @Test
    public void test_1() {
        String path = "src\\main\\resources\\mysql.properties";
//        String path= Objects.requireNonNull(this.getClass().getClassLoader().getResource("mysql.properties")).getPath();
        System.out.println(System.getProperty("user.dir"));
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
            properties.list(System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_2() {
        String path = "src\\main\\resources\\create.properties";
        System.out.println(System.getProperty("user.dir"));
        Properties properties = new Properties();
        properties.setProperty("name", "张三");
        properties.setProperty("age", "22");
        properties.setProperty("nation", "china");
        properties.list(System.out);
        try (FileOutputStream fos = new FileOutputStream(path)) {
            properties.store(fos, "info");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_3() {
        String path = "src\\main\\resources\\update.properties";
        System.out.println(System.getProperty("user.dir"));
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
            properties.list(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(path)) {
            properties.setProperty("key1","value1");
            properties.store(fos,"com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
