package leetcode2021;

public class LeetCode4 {

    public static void main(String[] args) {
        double res = new LeetCode4().findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2});
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int i = 0, j = 0;
        Integer a = null, b = null;
        while (i <= nums1.length || j <= nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] >= nums2[j]) {
                    a = b;
                    b = nums2[j];
                    j++;
                } else {
                    a = b;
                    b = nums1[i];
                    i++;
                }
            } else if (i == nums1.length) {
                a = b;
                b = nums2[j];
                j++;
            } else if (j == nums2.length) {
                a = b;
                b = nums1[i];
                i++;
            }
            if (i + j == (nums1.length + nums2.length) / 2 + 1) {
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return b;
                } else {
                    return (double) (a + b) / 2;
                }
            }
        }
        return 0;
    }
}
