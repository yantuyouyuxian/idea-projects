package nowcoder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 22:59
 * @ Description
 */
public class HJ36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String key = sc.nextLine();
            Set<Character> set = new LinkedHashSet<>();
            for (char c : key.toCharArray()) {
                set.add(c);
            }
            for (char c = 'a'; c <= 'z'; c++) {
                set.add(c);
            }
            List<Character> list = new ArrayList<>(set);
            String info = sc.nextLine();
            for (char c : info.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    System.out.print(list.get(c - 'a'));
                } else if (c >= 'A' && c <= 'Z') {
                    System.out.print(list.get(c - 'A'));
                }else{
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
