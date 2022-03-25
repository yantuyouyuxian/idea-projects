package leetcode2022.lc01_02;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/9 17:57
 * @ Description
 */
public class LeetCode918 {
    public static void main(String[] args) {
        LeetCode918 lc = new LeetCode918();
        System.out.println(lc.maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int curMinSum = nums[nums.length - 1];
        int minSum = nums[nums.length - 1];
        int curMaxSum = nums[nums.length - 1];
        int maxSum = nums[nums.length - 1];
        int total = curMinSum;
        for (int i = nums.length - 2; i >= 0; i--) {
            curMinSum = Math.min(nums[i], nums[i] + curMinSum);
            minSum = Math.min(minSum, curMinSum);
            curMaxSum = Math.max(nums[i], nums[i] + curMaxSum);
            maxSum = Math.max(maxSum, curMaxSum);
            total += nums[i];
        }
        System.out.println(minSum);
        System.out.println(maxSum);
        System.out.println(total);
        return Math.max(maxSum, total - minSum == 0 ? Integer.MIN_VALUE : total - minSum);
    }
}
