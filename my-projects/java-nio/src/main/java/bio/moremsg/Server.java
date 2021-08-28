package bio.moremsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 19:31
 * @ Description    接收一个客户端的多条信息
 */
public class Server {

    public static void main(String[] args) {
        try {
            //定义serversocket
            ServerSocket ss = new ServerSocket(9999);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("from:" + socket.getInetAddress() + ":" + socket.getPort() + " - " + msg);
                if (msg.equals("退出")) {
                    socket.close();
                    socket = ss.accept();
                    is = socket.getInputStream();
                    br = new BufferedReader(new InputStreamReader(is));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
