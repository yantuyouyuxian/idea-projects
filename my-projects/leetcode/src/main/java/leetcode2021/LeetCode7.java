package leetcode2021;

/**
 * @ Author         zhangHan
 * @ Date           2022/1/19 21:46
 * @ Description
 */
public class LeetCode7 {

    public static void main(String[] args) {
        LeetCode7 lc = new LeetCode7();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(lc.reverse(1534236469));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }



}
