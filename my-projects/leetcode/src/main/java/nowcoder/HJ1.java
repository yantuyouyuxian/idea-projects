package nowcoder;

import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 11:26
 * @ Description
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int sum=0;
            for (int i = 0; i < chars.length; i++) {
                if(chars[i]==' '){
                    sum=0;
                }else{
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
