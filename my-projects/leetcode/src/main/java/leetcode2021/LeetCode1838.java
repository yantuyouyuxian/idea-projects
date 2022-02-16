package leetcode2021;

import java.util.Arrays;

/**
 * @ Author         zhangHan
 * @ Date           2021/7/22 14:11
 * @ Description
 */
public class LeetCode1838 {

    public static void main(String[] args) {
        LeetCode1838 lc = new LeetCode1838();
        System.out.println(lc.maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(lc.maxFrequency(new int[]{3, 9, 6}, 2));
        System.out.println(lc.maxFrequency(new int[]{3}, 2));
        System.out.println(lc.maxFrequency(new int[]{1, 2, 4, 5, 7}, 4));
        System.out.println(lc.maxFrequency(new int[]{1, 2, 4}, 5));
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        while (right < nums.length - 1) {
            right++;
            k -= ((nums[right] - nums[right - 1]) * (right - left));
            if (k < 0) {
                left++;
                k += (nums[right] - nums[left - 1]);
            }
        }
        return right - left + 1;
    }
}
