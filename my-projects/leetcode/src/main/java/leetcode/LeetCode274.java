package leetcode;

import java.util.Arrays;

/**
 * @ Author         zhangHan
 * @ Date           2021/7/17 15:50
 * @ Description
 */
public class LeetCode274 {
    public static void main(String[] args) {
        LeetCode274 lc = new LeetCode274();
        System.out.println(lc.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(lc.hIndex(new int[]{1, 1, 3, 2}));
        System.out.println(lc.hIndex(new int[]{1, 1, 3, 2, 2, 4, 3, 4}));
        System.out.println(lc.hIndex(new int[]{100}));
        System.out.println(lc.hIndex(new int[]{1, 2}));
        System.out.println(lc.hIndex(new int[]{0}));
        System.out.println(lc.hIndex(new int[]{11, 15}));
        System.out.println(lc.hIndex(new int[]{4, 0, 0, 4}));
    }

    public int hIndex(int[] citations) {
        int res = 0;
        Arrays.sort(citations);
        int tem = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - i >= citations[i]) {
                res = Math.max(tem, citations[i]);
                break;
            }
            if (i == 0) {
                res = citations.length;
            }
            tem = citations.length - i;
        }
        return res;
    }
}
