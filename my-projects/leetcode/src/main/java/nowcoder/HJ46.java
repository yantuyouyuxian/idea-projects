package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 23:11
 * @ Description
 */
public class HJ46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());
            System.out.println(str.substring(0,num));
        }
    }
}
