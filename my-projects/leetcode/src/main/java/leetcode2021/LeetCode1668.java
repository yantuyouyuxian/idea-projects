package leetcode2021;

import org.junit.Test;

/**
 * @ Author         zhangHan
 * @ Date           2022/1/25 15:30
 * @ Description
 */
public class LeetCode1668 {
    public static void main(String[] args) {
        LeetCode1668 lc = new LeetCode1668();
        System.out.println(lc.numberOfMatches(14));
        System.out.println(lc.numberOfMatches(7));
        System.out.println(lc.numberOfMatches(1));
        System.out.println(lc.numberOfMatches(2));
        System.out.println(lc.numberOfMatches(3));
        System.out.println(lc.numberOfMatches(4));
    }

    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1) {
            res += n / 2;
            n = (n & 1) + (n >> 1);
        }
        return res;
    }

    @Test
    public void test() {
        int a = 13;
        System.out.println(a & 1);
    }
}
