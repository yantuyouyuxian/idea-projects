package leetcode2022.lc01_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/10 16:12
 * @ Description
 */
public class LeetCodeOffer62 {
    public static void main(String[] args) {
        LeetCodeOffer62 lc = new LeetCodeOffer62();
        System.out.println(lc.lastRemaining(10, 17));
    }

    public int lastRemaining(int n, int m) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        int curIndex = 0;
        int deleteIndex;
        while (nums.size() > 1) {
            deleteIndex = (curIndex + m - 1) % nums.size();
            int nextIndex = (deleteIndex + 1) % nums.size();
            if (nextIndex > deleteIndex) {
                nextIndex = deleteIndex;
            }
            nums.remove(deleteIndex);
            curIndex = nextIndex;
        }
        return nums.get(0);
    }


//    public int lastRemaining(int n, int m) {
//        int f = 0;
//        for (int i = 2; i != n + 1; ++i) {
//            f = (m + f) % i;
//        }
//        return f;
//    }

}
