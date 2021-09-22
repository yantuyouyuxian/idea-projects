package nio.buffer;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/31 21:19
 * @ Description
 */
public class BufferTest {

    //直接内存
    @Test
    public void test_a() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());
    }

    @Test
    public void test_1() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println("初始：");
        System.out.println("position: " + buffer.position());//0
        System.out.println("limit:" + buffer.limit());  //10
        System.out.println("capacity:" + buffer.capacity()); // 10
        System.out.println("-----------");
        buffer.put("zhang".getBytes());
        System.out.println("position: " + buffer.position());//
        System.out.println("limit:" + buffer.limit());  //
        System.out.println("capacity:" + buffer.capacity()); //
        System.out.println("-----------");
        buffer.flip();
        System.out.println("position: " + buffer.position());//
        System.out.println("limit:" + buffer.limit());  //
        System.out.println("capacity:" + buffer.capacity()); //
        System.out.println("-----------");
        System.out.println((char) buffer.get());
        System.out.println("position: " + buffer.position());//
        System.out.println("limit:" + buffer.limit());  //
        System.out.println("capacity:" + buffer.capacity()); //
    }

    @Test
    public void test_2() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("zhang".getBytes());
        print(buffer);
        buffer.clear();//仅仅重置指针
        print(buffer);
        System.out.println((char) buffer.get());
        print(buffer);
    }

    @Test
    public void test_3() {
        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.put("好好学习".getBytes());
        buffer.flip();
        byte[] data = new byte[6];
        buffer.get(data);
        String str = new String(data, StandardCharsets.UTF_8);
        System.out.println(str);
        print(buffer);
        buffer.mark();//标记当前position
        buffer.get(data);
        str = new String(data, StandardCharsets.UTF_8);
        System.out.println(str);
        print(buffer);
        buffer.reset();//回到标记点
        System.out.println(buffer.remaining());
        buffer.get(data);
        str = new String(data, StandardCharsets.UTF_8);
        System.out.println(str);
        print(buffer);
    }

    public void print(Buffer buffer) {
        System.out.println("---------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());
    }
}
