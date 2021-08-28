package bio.threadpool;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 21:05
 * @ Description     服务端
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9999)) {
            ServerHandlerPool pool = new ServerHandlerPool(4, 2);
            while (true) {
                Socket socket = ss.accept();
                Runnable task = new ServerTask(socket);
                pool.execute(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
