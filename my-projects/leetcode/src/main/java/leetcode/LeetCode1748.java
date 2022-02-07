package leetcode;

import java.util.HashMap;

/**
 * @ Author         zhangHan
 * @ Date           2022/2/6 21:52
 * @ Description
 */
public class LeetCode1748 {

    public static void main(String[] args) {
        LeetCode1748 lc = new LeetCode1748();
        System.out.println(lc.sumOfUnique(new int[]{1, 2, 3}));
    }

    public int sumOfUnique(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> flag = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = flag.getOrDefault(nums[i], 0);
            if (count.equals(0)) {
                sum += nums[i];
                flag.put(nums[i], 1);
            } else if (count.equals(1)) {
                sum -= nums[i];
                flag.put(nums[i], 2);
            }
        }
        return sum;
    }
}
