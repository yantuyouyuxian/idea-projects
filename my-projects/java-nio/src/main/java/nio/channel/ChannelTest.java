package nio.channel;


import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/31 22:28
 * @ Description
 */
public class ChannelTest {
    //FileChannel
    @Test
    public void test_write() {
        System.out.println(System.getProperty("user.dir"));
        try (FileOutputStream fos = new FileOutputStream("src\\main\\resources\\channel.txt");
             FileChannel channel = fos.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            buffer.put("好好学习".getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            channel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_read() {
        System.out.println(System.getProperty("user.dir"));
        try (FileInputStream fis = new FileInputStream("src\\main\\resources\\channel.txt");
             FileChannel channel = fis.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();
            String data = new String(buffer.array(), 0, buffer.remaining());
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_copy() {
        System.out.println(System.getProperty("user.dir"));
        try (FileInputStream fis = new FileInputStream("src\\main\\resources\\good.jpg");
             FileOutputStream fos = new FileOutputStream("src\\main\\resources\\good_copy.jpg");
             FileChannel inChannel = fis.getChannel();
             FileChannel outChannel = fos.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
