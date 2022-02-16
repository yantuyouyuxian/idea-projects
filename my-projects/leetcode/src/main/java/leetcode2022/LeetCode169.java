package leetcode2022;

import java.util.Arrays;

/**
 * @ Author         zhangHan
 * @ Date           2022/2/10 22:25
 * @ Description
 */
public class LeetCode169 {
    public static void main(String[] args) {
        LeetCode169 lc = new LeetCode169();

    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

//    public int majorityElement(int[] nums) {
//        int count = 0;
//        Integer candidate = null;
//        for (int num : nums) {
//            if (count == 0) {
//                candidate = num;
//            }
//            count += (num == candidate) ? 1 : -1;
//        }
//        return candidate;
//    }


}
