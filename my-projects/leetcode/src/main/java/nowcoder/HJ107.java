package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/28 23:41
 * @ Description
 */
public class HJ107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            double num = Double.parseDouble(str);
            function(-20, 20, num);
        }
    }

    public static double getMulti(double x) {
        return x * x * x;
    }

    public static void function(double left, double right, double target) {
        double mid = (left + right) / 2;
        double mmm = getMulti(mid);
        if (Math.abs(mmm - target) < 0.01) {
            System.out.printf("%.1f%n", mid);
        } else {
            if (mmm > target) {
                function(left, mid, target);
            } else {
                function(mid, right, target);
            }
        }
    }
}
