package bio.moreclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 20:31
 * @ Description
 */
public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("from:" + socket.getInetAddress() + ":" + socket.getPort() + " - " + msg);
                if (msg.equals("exit")) {
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
