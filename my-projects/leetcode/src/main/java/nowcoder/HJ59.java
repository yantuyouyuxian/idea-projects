package nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/27 23:05
 * @ Description
 */
public class HJ59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            Set<Character> firstSet = new LinkedHashSet<>();
            Set<Character> moreSet = new HashSet<>();
            for (int i = 0; i < chars.length; ) {
                Character c = chars[i];
                if (moreSet.contains(c)) {
                    i++;
                } else if (firstSet.contains(c)) {
                    firstSet.remove(c);
                    moreSet.add(c);
                    i++;
                } else {
                    firstSet.add(c);
                    i++;
                }
            }
            List<Character> list = new ArrayList<>(firstSet);
            if (list.size() > 0) {
                System.out.println(list.get(0));
            } else {
                System.out.println("-1");
            }
        }
    }
}
