package nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @ Author         zhangHan
 * @ Date           2021/9/6 16:13
 * @ Description
 */
public class Server {

    private Selector selector;
    private ServerSocketChannel ssc;
    private static final int PORT = 9996;

    public Server() {
        try {
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(PORT));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //开始监听
    public void listen() {
        try {
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isAcceptable()) {
                        //接入事件
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                        System.out.println("客户端[" + sc.getRemoteAddress() + "]" + "接入");
                    } else if (sk.isReadable()) {
                        readClientData(sk);
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //接收当前客户端通道的信息,转发给其他客户端
    public void readClientData(SelectionKey sk) {
        SocketChannel sc = null;
        try {
            sc = (SocketChannel) sk.channel();
            ByteBuffer bf = ByteBuffer.allocate(1024);
            int count = sc.read(bf);
            if (count > 0) {
                bf.flip();
                String msg = new String(bf.array(), 0, bf.remaining());
                System.out.println("接收客户端[" + sc.getRemoteAddress() + "]消息:" + msg);
                sendMsgToAll("接收客户端[" + sc.getRemoteAddress() + "]消息:" + msg, sc);
            }
        } catch (Exception e) {
            try {
                System.out.println("客户端[" + sc.getRemoteAddress() + "]离线");
                sk.cancel();//从选择器中去除
                sc.close();//关闭通道
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void sendMsgToAll(String msg, SocketChannel sc) throws IOException {
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            if (channel instanceof SocketChannel && channel != sc) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel) channel).write(buffer);
            }
        }
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.listen();
    }
}
