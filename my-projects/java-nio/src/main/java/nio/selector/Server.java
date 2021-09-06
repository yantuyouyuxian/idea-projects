    package nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @ Author         zhangHan
 * @ Date           2021/9/4 22:02
 * @ Description
 */
public class Server {
    public static void main(String[] args) {
        try (
                ServerSocketChannel ssc = ServerSocketChannel.open();
        ) {
            //非阻塞
            ssc.configureBlocking(false);
            //绑定端口
            ssc.bind(new InetSocketAddress(9997));
            //获取选择器
            Selector selector = Selector.open();
            //将通道注册到选择器，并指定监听接受事件类型
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            //使用选择器轮询事件
            while (selector.select() > 0) {
                //获取选择器中的所有注册的通道中已经就绪的事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //开始遍历就绪的事件
                while (iterator.hasNext()) {
                    //提取当前事件
                    SelectionKey sk = iterator.next();
                    //判断事件类型
                    if (sk.isAcceptable()) {
                        //如果是接入事件，获取接入的客户端通道
                        SocketChannel sc = ssc.accept();
                        //切换到非阻塞模式
                        sc.configureBlocking(false);
                        //将接入的客户端通道注册到选择器
                        sc.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        //如果是读事件
                        SocketChannel sc = (SocketChannel) sk.channel();
                        ByteBuffer bf = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = sc.read(bf)) > 0) {
                            bf.flip();
                            System.out.println(new String(bf.array(), 0, len));
                            bf.clear();
                        }
                    }
                    //处理过的事件要移除
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
