package bio.portresend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/30 20:45
 * @ Description
 */
public class ServerTask extends Thread {
    private Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            //读取客户端发送的消息
            String msg;
            while ((msg = br.readLine()) != null) {
                sendMsgToAllClient(socket, msg);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            Server.allSocket.remove(socket);
            sendMsgToAllClient(socket, "exit");
        }
    }

    public void sendMsgToAllClient(Socket socket, String msg) {
        for (Socket client : Server.allSocket) {
            try (PrintStream ps = new PrintStream(client.getOutputStream())) {
                ps.println(socket.getInputStream() + ":" + socket.getPort() + "->" + msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
