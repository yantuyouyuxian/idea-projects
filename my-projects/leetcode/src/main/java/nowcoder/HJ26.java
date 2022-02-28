package nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 21:02
 * @ Description
 */
public class HJ26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            List<Character> list = new ArrayList<>();
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c)) {
                    list.add(c);
                }
            }

            list.sort(Comparator.comparingInt(Character::toLowerCase));

            for (int i = 0, j = 0; i < str.length(); i++) {
                if(Character.isLetter(str.charAt(i))){
                    System.out.print(list.get(j++));
                }else{
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
