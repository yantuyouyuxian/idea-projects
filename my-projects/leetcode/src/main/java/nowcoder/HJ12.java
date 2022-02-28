package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 11:57
 * @ Description
 */
public class HJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
}
