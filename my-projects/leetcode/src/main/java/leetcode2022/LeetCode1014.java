package leetcode2022;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/10 22:28
 * @ Description
 */
public class LeetCode1014 {
    public static void main(String[] args) {
        LeetCode1014 lc = new LeetCode1014();
        System.out.println(lc.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(lc.maxScoreSightseeingPair(new int[]{1, 2}));
        System.out.println(lc.maxScoreSightseeingPair(new int[]{2, 7, 7, 2, 1, 7, 10, 4, 3, 3}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int i = 0;
        int left = values[i] + i;
        int max = left;
        for (int j = 1; j < values.length; j++) {
            max = Math.max(max, left + values[j] - j);
            left = Math.max(left, values[j] + j);
        }
        return max;
    }
}
