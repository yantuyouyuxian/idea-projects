package nio.sacttergather;

import org.junit.Test;

import sun.rmi.runtime.NewThreadAction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/31 23:03
 * @ Description
 */
public class ScatterGatherTest {

    @Test
    public void test_01(){
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime endTime = nowTime.plusHours(2);
        System.out.println(Duration.between(nowTime, endTime).toHours());
        System.out.println(Duration.between(endTime, nowTime).toHours());
    }

    @Test
    public void test_02() {
        try (
                FileInputStream fis = new FileInputStream("src\\main\\resources\\xshell.exe");
                FileChannel inChannel = fis.getChannel();
                FileOutputStream fos = new FileOutputStream("src\\main\\resources\\xshell_s_g.exe");
                FileChannel outChannel = fos.getChannel()
        ) {
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);
            ByteBuffer[] buffers = new ByteBuffer[]{buffer1, buffer2};
            while (inChannel.read(buffers) != -1) {
                for (ByteBuffer buffer : buffers) {
                    buffer.flip();
                }
                outChannel.write(buffers);
                for (ByteBuffer buffer : buffers) {
                    buffer.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
