package nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 20:36
 * @ Description
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();

            for (char c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            Integer minTimes = Integer.MAX_VALUE;
            for (Integer value : map.values()) {
                minTimes = Math.min(value, minTimes);
            }
            for (char c : str.toCharArray()) {
                if (!map.get(c).equals(minTimes)) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
