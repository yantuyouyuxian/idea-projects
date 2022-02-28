package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/28 23:14
 * @ Description
 */
public class HJ55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
