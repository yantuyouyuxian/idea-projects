package leetcode2022.lc03;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/25 21:53
 * @ Description
 */
public class LeetCode172 {
    public static void main(String[] args) {
        LeetCode172 lc = new LeetCode172();
        System.out.println(lc.trailingZeroes(3125));
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
