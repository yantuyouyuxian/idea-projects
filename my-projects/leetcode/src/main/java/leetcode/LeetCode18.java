package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/4 9:41
 * @ Description
 */
public class LeetCode18 {

    public static void main(String[] args) {
        LeetCode18 lc = new LeetCode18();
        System.out.println(lc.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(lc.fourSum(new int[]{2, 2, 2, 2}, 8));
        System.out.println(lc.fourSum(new int[]{}, 0));
        System.out.println(lc.fourSum(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(lc.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
    }

    public List<List<Integer>> fourSumOfficial(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] arr = new int[4];
        getNumsFromList(nums, target, 4, 0, arr, result);
        return result;
    }

    public void getNumsFromList(int[] nums, int target, int n, int p, int[] arr, List<List<Integer>> result) {
        if (n > 1) {
            for (int i = p; i < nums.length - n + 1; ) {
                int minSum = nums[i];
                int maxSum = nums[i];
                for (int k = n - 1; k > 0; k--) {
                    minSum += nums[i + k];
                    maxSum += nums[nums.length - k];
                }
                if (minSum > target) {
                    break;
                }
                if (maxSum < target) {
                    i++;
                }
                arr[4 - n] = nums[i];
                getNumsFromList(nums, target - nums[i], n - 1, i + 1, arr, result);
                int j = i + 1;
                while (j < nums.length && nums[j] == nums[i]) {
                    j++;
                }
                i = j;
            }
        } else {
            for (int i = p; i < nums.length; ) {
                if (nums[i] > target) {
                    break;
                }
                if (nums[i] == target) {
                    arr[4 - n] = nums[i];
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int num : arr) {
                        list.add(num);
                    }
                    result.add(list);
                }
                int j = i + 1;
                while (j < nums.length && nums[j] == nums[i]) {
                    j++;
                }
                i = j;
            }
        }
    }

}
