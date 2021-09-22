package bio.fileupload;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/29 16:32
 * @ Description
 */
public class ServerFileTask extends Thread {
    private Socket socket;

    public ServerFileTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            System.out.println("server。dir: " + System.getProperty("user.dir"));
            String suffix = dis.readUTF();
            String fileName = UUID.randomUUID().toString().replace("-", "");
            FileOutputStream fos = new FileOutputStream("java-nio\\src\\main\\resources\\" + fileName + suffix);
            byte[] data = new byte[1024];
            int len;
            while ((len = dis.read(data)) != -1) {
                fos.write(data, 0, len);
            }
            fos.flush();
            fos.close();//final
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
