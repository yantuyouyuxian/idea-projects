package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/25 22:01
 * @ Description
 */
public class HJ80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                treeSet.add(sc.nextInt());
            }
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                treeSet.add(sc.nextInt());
            }
            treeSet.forEach(System.out::print);
            System.out.println();
        }
    }
}
