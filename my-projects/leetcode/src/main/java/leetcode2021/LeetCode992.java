package leetcode2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode992 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        LeetCode992 lc = new LeetCode992();
        System.out.println(lc.solution_2(arr, k));
    }

    public int solution_1(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            Set set = new HashSet<Integer>();
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if (set.size() == k) {
                    res++;
                } else if (set.size() > k) {
                    break;
                }
            }
        }
        return res;
    }

    public int solution_2(int[] nums, int k) {
        return function_2(nums, k) - function_2(nums, k - 1);
    }

    //最多包含k个数字的子区间的个数
    public int function_1(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length) {
            if (numCount.containsKey(nums[right])) {
                numCount.replace(nums[right], numCount.get(nums[right]) + 1);
            } else {
                numCount.put(nums[right], 1);
            }
            right++;
            while (numCount.size() > k) {
                if (numCount.get(nums[left]) == 1) {
                    numCount.remove(nums[left]);
                } else {
                    numCount.replace(nums[left], numCount.get(nums[left]) - 1);
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }

    public int function_2(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;
        int[] numCount = new int[nums.length + 1];
        int count = 0;//不同的数字个数
        while (right < nums.length) {
            if (numCount[nums[right]] == 0) {
                count++;
            }
            numCount[nums[right]]++;
            right++;
            while (count > k) {
                numCount[nums[left]]--;
                if (numCount[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
