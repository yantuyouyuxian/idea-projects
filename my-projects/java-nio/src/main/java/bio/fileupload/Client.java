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


        try (Socket socket = new Socket("127.0.0.1", 9999);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             FileInputStream fis = new FileInputStream("src\\main\\resources\\good.jpg")) {
            dos.writeUTF(".jpg");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
