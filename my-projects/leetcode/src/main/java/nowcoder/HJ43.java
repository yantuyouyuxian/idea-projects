package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/28 22:49
 * @ Description
 */
public class HJ43 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        boolean[][] arrive = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                arrive[i][j] = false;
            }
        }
    }

}
