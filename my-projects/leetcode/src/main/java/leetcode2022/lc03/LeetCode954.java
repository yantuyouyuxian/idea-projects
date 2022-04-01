package leetcode2022.lc03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author         zhangHan
 * @ Date           2022/4/1 12:00
 * @ Description
 */
public class LeetCode954 {
    public static void main(String[] args) {

    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> nums = new ArrayList<>(cnt.keySet());
        nums.sort(Comparator.comparingInt(Math::abs));
        for (Integer num : nums) {
            if (cnt.getOrDefault(2 * num, 0) < cnt.get(num)) {
                return false;
            }
            cnt.put(num * 2, cnt.getOrDefault(2 * num, 0) - cnt.get(num));
        }
        return true;
    }
}
