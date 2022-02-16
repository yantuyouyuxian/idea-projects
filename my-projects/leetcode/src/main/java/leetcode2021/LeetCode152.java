package leetcode2021;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/8 21:00
 * @ Description
 */
public class LeetCode152 {
    public static void main(String[] args) {
        LeetCode152 lc = new LeetCode152();
        System.out.println(lc.maxProduct(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}));
        System.out.println(lc.maxProduct(new int[]{1, 2, 3, 4, 0, 4, 3, 2, 1}));
        System.out.println(lc.maxProduct(new int[]{1, 2, -3, 4, 5, 4, 3, 2, 1}));
    }

    public int maxProduct(int[] nums) {
        int p = 1;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            p *= nums[i];
            max = Math.max(p, max);
            if (nums[i] == 0) {
                p = 1;
            }
        }
        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            p *= nums[i];
            max = Math.max(p, max);
            if (nums[i] == 0) {
                p = 1;
            }
        }
        return max;
    }
}
