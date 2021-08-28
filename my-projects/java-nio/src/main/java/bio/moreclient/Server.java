package bio.moreclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 20:25
 * @ Description    多个客户端的消息处理，接收的每个socket都交给一个线程进行处理
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true) {
                Socket socket = ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


