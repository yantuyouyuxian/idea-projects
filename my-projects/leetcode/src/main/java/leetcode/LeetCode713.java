package leetcode;

/**
 * @ Author         zhangHan
 * @ Date           2021/7/15 9:59
 * @ Description    请找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class LeetCode713 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        LeetCode713 lt = new LeetCode713();
        System.out.println(lt.numSubarrayProductLessThanK(arr, 0));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;
        int product = 1;
        while (right < nums.length) {
            product *= nums[right];
            right++;
            while (product >= k && left <right) {
                product /= nums[left];
                left++;
            }
            res += (right - left);
        }
        return res;
    }
}
