package leetcode;

import java.util.Arrays;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/21 15:14
 * @ Description
 */
public class LeetCode475 {
    int[] houses = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] heaters = {4};

    public static void main(String[] args) {
        LeetCode475 lt = new LeetCode475();
        System.out.println(lt.findRadius(lt.houses, lt.heaters));
    }


    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0;
        int maxDis = 0 ;
        while (i < houses.length) {
            int curMinDis = Math.abs(houses[i] - heaters[Math.min(j, heaters.length - 1)]);
            while (j < heaters.length && Math.abs(houses[i] - heaters[Math.min(j + 1, heaters.length - 1)]) <= curMinDis) {
                j++;
                curMinDis = Math.abs(houses[i] - heaters[Math.min(j, heaters.length - 1)]);
            }
            maxDis = Math.max(maxDis, curMinDis);
            i++;
        }
        return maxDis;
    }


}
