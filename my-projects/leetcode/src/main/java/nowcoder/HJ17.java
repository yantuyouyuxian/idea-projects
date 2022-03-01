package nowcoder;

import java.util.Scanner;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/1 20:50
 * @ Description
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int x = 0, y = 0;
            String pattern = "[WASD][0-9]+";
            for (String item : str.split(";")) {
                if (item.matches(pattern)) {
                    int value = Integer.parseInt(item.substring(1));
                    switch (item.charAt(0)) {
                        case 'W':
                            y += value;
                            break;
                        case 'S':
                            y -= value;
                            break;
                        case 'A':
                            x -= value;
                            break;
                        case 'D':
                            x += value;
                            break;
                    }
                }
            }
            System.out.println(x + "," + y);
        }
    }
}

//A10;S20;W10;D30;X;A1A;B10A11;;A10;
//ABC;AKL;DA1;
