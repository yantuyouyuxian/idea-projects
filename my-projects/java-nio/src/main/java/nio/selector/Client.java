package nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ Author         zhangHan
 * @ Date           2021/9/4 22:02
 * @ Description
 */
public class Client {
    public static void main(String[] args) {

        try (
                //获取通道
                SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9997))
        ) {
            //非阻塞模式
            sc.configureBlocking(false);
            ByteBuffer bf = ByteBuffer.allocate(1024);
            //发送数据给服务端
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("to-server:");
                String msg = scanner.nextLine();
                bf.put(("locAddress:" + sc.getLocalAddress().toString() + "   remoteAddress:" + sc.getRemoteAddress() + "::" + msg).getBytes(StandardCharsets.UTF_8));
                bf.flip();
                sc.write(bf);
                bf.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
