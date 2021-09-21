package nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ Author         zhangHan
 * @ Date           2021/9/6 16:13
 * @ Description
 */
public class Client {

    private Selector selector;
    private static int PORT = 9996;
    private SocketChannel socketChannel;

    public Client() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        //准备接受消息
        new Thread(() -> {
            try {
                client.readInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            client.sendMsgToServer(msg);
        }
    }

    private void sendMsgToServer(String msg) throws IOException {
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }

    private void readInfo() throws IOException {
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey sk = iterator.next();
                if (sk.isReadable()) {
                    SocketChannel sc = (SocketChannel) sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    sc.read(buffer);
                    System.out.println(new String(buffer.array()).trim());
                }
                iterator.remove();
            }
        }
    }
}
