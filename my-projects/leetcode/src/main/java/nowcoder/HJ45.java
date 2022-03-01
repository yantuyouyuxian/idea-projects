package nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/1 22:42
 * @ Description
 */
public class HJ45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine().toLowerCase(Locale.ROOT));
            }
            for (String name : list) {
                int res = 0;
                Map<Character, Integer> countMap = new HashMap<>();
                for (char c : name.toCharArray()) {
                    Integer count = countMap.getOrDefault(c, 0);
                    countMap.put(c, count + 1);
                }
                List<Map.Entry<Character, Integer>> entries = countMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
                int x = 26;
                for (Map.Entry<Character, Integer> entry : entries) {
                    res += entry.getValue() * x;
                    x--;
                }
                System.out.println(res);
            }
        }
    }
}
