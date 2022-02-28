package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 11:34
 * @ Description
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int length = chars.length;
            while (length % 8 != 0) {
                length++;
            }
            for (int i = 0; i < length; i++) {
                if (i < chars.length) {
                    System.out.print(chars[i]);
                } else {
                    System.out.print("0");
                }
                if ((i + 1) % 8 == 0) {
                    System.out.println();
                }
            }

        }
    }
}
