package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/28 21:56
 * @ Description
 */
public class HJ92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            List<String> numberList = new ArrayList<>();
            int maxLen = 0;
            for (int i = 0; i < chars.length; ) {
                if (Character.isDigit(chars[i])) {
                    StringBuilder sb = new StringBuilder();
                    while (i < chars.length && Character.isDigit(chars[i])) {
                        sb.append(chars[i]);
                        i++;
                    }
                    maxLen = Math.max(sb.length(), maxLen);
                    numberList.add(sb.toString());
                } else {
                    i++;
                }
            }
            for (int i = 0; i < numberList.size(); i++) {
                if (numberList.get(i).length() == maxLen) {
                    System.out.print(numberList.get(i));
                }
            }
            System.out.println("," + maxLen);
        }
    }
}
