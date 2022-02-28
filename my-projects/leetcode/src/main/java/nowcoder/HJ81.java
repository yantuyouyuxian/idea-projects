package nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/28 21:49
 * @ Description
 */
public class HJ81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            Set<Integer> set = new HashSet<>();
            for (char c : s2.toCharArray()) {
                set.add((int)c);
            }
            String result = "true";
            for (char c : s1.toCharArray()) {
                if(!set.contains((int)c)){
                    result = "false";
                }
            }
            System.out.println(result);
        }
    }
}
