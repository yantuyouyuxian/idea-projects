package bio.portresend;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/29 17:04
 * @ Description    群聊案例
 */
public class Server {
    public static List<Socket> allSocket = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9999)) {
            while (true) {
                Socket socket = ss.accept();
                allSocket.add(socket);
                new ServerTask(socket).start();
            }
        } catch (Exception e) {

        }
    }

}

