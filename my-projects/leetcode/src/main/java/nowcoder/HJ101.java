package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/26 0:03
 * @ Description
 */
public class HJ101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int flag = sc.nextInt();
            Arrays.sort(arr);
            if (flag == 0) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }


    public static void quickSort(int left, int right, int[] arr) {
        if (left > right) {
            return;
        }
        int originLeft = left;
        int originRight = right;
        int value = arr[left];
        while (left < right) {
            while (arr[right] >= value && left < right) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
            while (arr[left] <= value && left < right) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        quickSort(originLeft, left - 1, arr);
        quickSort(right + 1, originRight, arr);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
