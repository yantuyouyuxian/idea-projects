package bio.fileupload;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 22:12
 * @ Description
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("client.dir: " + System.getProperty("user.dir"));
        try (Socket socket = new Socket("127.0.0.1", 9999);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             FileInputStream fis = new FileInputStream("java-nio\\src\\main\\resources\\xshell.exe")) {
            dos.writeUTF(".exe");
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                dos.write(data, 0, len);
            }
            dos.flush();
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
