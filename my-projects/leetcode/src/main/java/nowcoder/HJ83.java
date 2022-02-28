package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/25 22:24
 * @ Description
 */
public class HJ83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row > 9 || col > 9) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            if (x1 > row - 1 || y1 > col - 1 || x2 > row - 1 || y2 > col - 1) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }

            int addRow = sc.nextInt();
            if (addRow < 0 || addRow > row - 1 || row == 9) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }

            int addCol = sc.nextInt();
            if (addCol < 0 || addCol > col - 1 || col == 9) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }


            x1 = sc.nextInt();
            y1 = sc.nextInt();

            if (x1 > row - 1 || y1 > col - 1) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
        }
    }
}
