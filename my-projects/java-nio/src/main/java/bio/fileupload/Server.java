package bio.fileupload;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 22:12
 * @ Description
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9999)) {
            while (true) {
                Socket socket = ss.accept();
                new ServerFileTask(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
