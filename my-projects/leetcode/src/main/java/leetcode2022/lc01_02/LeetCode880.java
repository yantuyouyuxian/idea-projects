package leetcode2022.lc01_02;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/5 21:27
 * @ Description
 */
public class LeetCode880 {


    public static void main(String[] args) {
        LeetCode880 lc = new LeetCode880();
        System.out.println(lc.decodeAtIndex("y959q969u3hb22odq595", 222280369));
        System.out.println(lc.decodeAtIndex("leet2code3", 10));
        System.out.println(lc.decodeAtIndex("ha22", 5));
        System.out.println(lc.decodeAtIndex("a2345678999999999999999", 1));
        System.out.println(lc.decodeAtIndex("a2b3c4d5e6f7g8h9", 10));
    }

    public String decodeAtIndex(String s, int k) {
        char[] chars = s.toCharArray();
        long length = 0L;
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                length++;
            } else {
                length = length * (aChar - '0');
            }
        }
        char c;
        for (int i = chars.length - 1; i >= 0; i--) {
            k %= length;
            c = chars[i];
            if (Character.isDigit(c)) {
                length = length / (c - '0');
            } else {
                if (k == 0) {
                    return Character.toString(c);
                } else {
                    length--;
                }
            }
        }
        return null;
    }
}
