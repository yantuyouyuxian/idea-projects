package leetcode2022;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/1 23:52
 * @ Description
 */
public class LeetCode11 {

    public static void main(String[] args) {
        LeetCode11 lc = new LeetCode11();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(lc.maxArea(arr));
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int i = 0, j = len - 1;
        while (i != j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

//    public int maxArea(int[] height) {
//        int len = height.length;
//        int maxArea = 0;
//        for (int i = 0; i < len; i++) {
//            int j = findHigherItem(i, height, len);
//            maxArea = Math.max(maxArea, Math.abs(i - j) * height[i]);
//        }
//        return maxArea;
//    }

    public int findHigherItem(int index, int[] height, int len) {
        int i;
        if (index >= len / 2) {
            i = 0;
            while (height[i] < height[index]) {
                i++;
            }
        } else {
            i = len - 1;
            while (height[i] < height[index]) {
                i--;
            }
        }
        return i;
    }

}
