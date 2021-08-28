package bio.threadpool;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 22:03
 * @ Description
 */
public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999);
             OutputStream os = socket.getOutputStream();
             PrintStream ps = new PrintStream(os)) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("->");
                String msg = scanner.nextLine();
                ps.println(msg);
                ps.flush();
                if (msg.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
