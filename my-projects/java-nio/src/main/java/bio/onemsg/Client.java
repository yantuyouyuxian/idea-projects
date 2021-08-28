package bio.onemsg;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 19:31
 * @ Description
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream ps = new PrintStream(outputStream);
            String msg = "好好学习";
            ps.println(msg);
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
