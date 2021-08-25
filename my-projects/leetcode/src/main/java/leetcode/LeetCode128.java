package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import java.util.stream.IntStream;

public class LeetCode128 {

    public static void main(String[] args) {
        LeetCode128 lc = new LeetCode128();
        int[] arr = lc.generateArray(50000);
        long l = System.currentTimeMillis();
        int res1 = lc.longestConsecutive_1(arr);
        System.out.println("res1=" + res1);
        System.out.println(System.currentTimeMillis() - l);

    }

    public int[] generateArray(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Random().nextInt(50000);
        }
        return arr;
    }

    public int longestConsecutive_1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        final int[] len = {1};
        IntStream intStream = Arrays.stream(nums);
        intStream.boxed().forEach(e -> {
            if (map.containsKey(e)) {
                int b = map.get(e) + 1;
                map.put(e + 1, b);
                len[0] = Math.max(b, len[0]);
                map.remove(e);
            } else if (!map.containsKey(e + 1)) {
                map.put(e + 1, 1);
            }
        });
        return len[0];
    }
}
