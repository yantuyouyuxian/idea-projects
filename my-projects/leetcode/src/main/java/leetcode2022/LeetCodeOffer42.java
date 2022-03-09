package leetcode2022;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/9 17:43
 * @ Description
 */
public class LeetCodeOffer42 {
    public static void main(String[] args) {
        LeetCodeOffer42 lc = new LeetCodeOffer42();
        System.out.println(lc.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(lc.minSubArray(new int[]{-2, 1, -3, 4, -1, 2, -5, -5, 4}));
    }

    // 连续子数组的最大和
    public int maxSubArray(int[] nums) {
        int curMaxSum = nums[nums.length - 1];
        int maxSum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            curMaxSum = Math.max(nums[i], nums[i] + curMaxSum);
            maxSum = Math.max(maxSum, curMaxSum);
        }
        return maxSum;
    }

    // 连续子数组的最小和
    public int minSubArray(int[] nums) {
        int curMinSum = nums[nums.length - 1];
        int minSum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            curMinSum = Math.min(nums[i], nums[i] + curMinSum);
            minSum = Math.min(minSum, curMinSum);
        }
        return minSum;
    }
}
