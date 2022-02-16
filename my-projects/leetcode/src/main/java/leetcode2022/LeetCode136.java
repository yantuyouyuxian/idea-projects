package leetcode2022;

/**
 * @ Author         zhangHan
 * @ Date           2022/2/10 22:19
 * @ Description
 */
public class LeetCode136 {
    public static void main(String[] args) {
        LeetCode136 lc = new LeetCode136();
        System.out.println(lc.singleNumber(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 5}));
    }

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
