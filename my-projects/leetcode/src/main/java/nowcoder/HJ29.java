package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 21:24
 * @ Description
 */
public class HJ29 {
    // A-Z: 65-90
    // a-z: 97-122
    // 0-9: 48-57
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str1 = sc.nextLine();
            for (char c : str1.toCharArray()) {
                if (Character.isLetter(c)) {
                    // 加密
                    if (c >= 'A' && c <= 'Z') {
                        char c1 = (char) ((c - 'A' + 1) % 26 + 'a');
                        System.out.print(c1);
                    } else {
                        char c2 = (char) ((c - 'a' + 1) % 26 + 'A');
                        System.out.print(c2);
                    }
                } else {
                    char c3 = (char) ((c - '0' + 1) % 10 + '0');
                    System.out.print(c3);
                }
            }
            System.out.println();
            String str2 = sc.nextLine();
            for (char c : str2.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (c >= 'A' && c <= 'Z') {
                        char c1 = (char) ((c - 'A' + 26 - 1) % 26 + 'a');
                        System.out.print(c1);
                    } else {
                        char c2 = (char) ((c - 'a' + 26 - 1) % 26 + 'A');
                        System.out.print(c2);
                    }
                } else {
                    char c3 = (char) ((c - '0' + 10 - 1) % 10 + '0');
                    System.out.print(c3);
                }
            }
            System.out.println();
        }
    }
}
