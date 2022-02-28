package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/27 23:45
 * @ Description
 */
public class HJ65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String strShort = sc.nextLine();
            String strLong = sc.nextLine();
            if (strShort.length() > strLong.length()) {
                String temp = strShort;
                strShort = strLong;
                strLong = temp;
            }
            all:
            for (int i = strShort.length(); i > 0; i--) {
                for (int j = 0; j + i <= strShort.length(); j++) {
                    String subString = strShort.substring(j, j + i);
                    if (strLong.contains(subString)) {
                        System.out.println(subString);
                        break all;
                    }
                }
            }

        }
    }
}

//    abcdefghijklmnop
//    abcsafjklmnopqrstuvw
