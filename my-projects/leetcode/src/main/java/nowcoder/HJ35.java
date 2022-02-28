package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/28 23:22
 * @ Description
 */
public class HJ35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int maxNum = (1 + n) * n / 2;
            for (int i = 1; i <= n; i++) {
                int min = (1 + i) * i / 2 - i + 1;
                int max = maxNum - i + 1;
                int p = i + 1;
                for (int j = min; j <= max; ) {
                    System.out.print(j + " ");
                    j += p;
                    p++;
                }
                System.out.println();
            }
        }
    }
}
