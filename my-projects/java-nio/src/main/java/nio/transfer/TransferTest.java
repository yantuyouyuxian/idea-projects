package nio.transfer;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @ Author         zhangHan
 * @ Date           2021/9/3 20:39
 * @ Description
 */
public class TransferTest {

    @Test
    public void test_01() {
        try (FileInputStream fis = new FileInputStream("src\\main\\resources\\good.jpg");
             FileChannel isChannel = fis.getChannel();
             FileOutputStream fos1 = new FileOutputStream("src\\main\\resources\\transferfrom.jpg");
             FileChannel osChannel1 = fos1.getChannel();
             FileOutputStream fos2 = new FileOutputStream("src\\main\\resources\\transferto.jpg");
             FileChannel osChannel2 = fos2.getChannel()
        ) {
            osChannel1.transferFrom(isChannel,isChannel.position(),isChannel.size());
            isChannel.transferTo(isChannel.position(),isChannel.size(),osChannel2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
