package leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/2 22:41
 * @ Description
 */
public class LeetCode15 {
    public static void main(String[] args) {
        LeetCode15 lc = new LeetCode15();
        System.out.println(lc.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
        System.out.println(lc.threeSum(new int[]{0, 0, 0, 0}));
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums.length < 3) return result;
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                if (nums[i] + nums[j] > 0) {
//                    break;
//                }
//                if (j > i + 1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] > 0) {
//                        break;
//                    }
//                    if (k > j + 1 && nums[k] == nums[k - 1]) {
//                        continue;
//                    }
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                        break;
//                    }
//                }
//            }
//        }
//        return result;
//    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            if (nums[i] + nums[j] > 0 || nums[k] < 0) {
                break;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) j++;
                    while (j < k && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

}
