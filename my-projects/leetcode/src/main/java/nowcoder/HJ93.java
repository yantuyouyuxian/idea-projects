package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/25 22:47
 * @ Description
 */
public class HJ93 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int threeSum = 0;
            int fiveSum = 0;
            List<Integer> others = new ArrayList<>();
            int allSum = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x % 5 == 0) {
                    fiveSum += x;
                } else if (x % 3 == 0) {
                    threeSum += x;
                } else {
                    others.add(x);
                }
                allSum += x;
            }
            if (allSum % 2 != 0) {
                System.out.println(false);
            } else {
                int target = allSum / 2 - fiveSum;
                System.out.println(findTarget(0, target, others));
            }
        }
    }

    public static boolean findTarget(int index, int target, List<Integer> list) {
        if (index == list.size()) {
            return target == 0;
        }
        return findTarget(index + 1, target - list.get(index), list) || findTarget(index + 1, target, list);
    }
}
