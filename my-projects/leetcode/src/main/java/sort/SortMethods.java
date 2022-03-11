package sort;

import java.util.Arrays;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/10 16:42
 * @ Description
 */
public class SortMethods {
    public static void main(String[] args) {
        int[] nums = new int[]{43, 12, 99, 10, 22, 3, 17};
//        bubbleSort(nums);
        quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void quickSort(int l, int r, int[] nums) {
        if (l > r) return;
        int flag = nums[l];
        int left = l, right = r;
        while (left < right) {
            while (nums[right] >= flag && left < right) {
                right--;
            }
            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }

            while (nums[left] <= flag && left < right) {
                left++;
            }
            if (left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        quickSort(l, left - 1, nums);
        quickSort(right + 1, r, nums);

    }
}
