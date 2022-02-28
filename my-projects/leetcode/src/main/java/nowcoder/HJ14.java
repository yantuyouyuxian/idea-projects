package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 12:21
 * @ Description
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine());
            }
            Collections.sort(list);
            list.forEach(System.out::println);
        }
    }
}
