package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author         zhangHan
 * @ Date           2022/1/17 23:56
 * @ Description
 */
public class LeetCode1 {
    public static void main(String[] args) {
        LeetCode1 lc = new LeetCode1();
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(lc.twoSum(nums, target)));
    }

//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            int temp = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == temp) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[0];
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}
