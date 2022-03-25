package leetcode2022.lc01_02;

/**
 * @ Author         zhangHan
 * @ Date           2022/2/12 15:28
 * @ Description
 */
public class LeetCode240 {
    public static void main(String[] args) {
        LeetCode240 lc = new LeetCode240();
        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
                {-1, 3}
        };
        System.out.println(lc.searchMatrix(matrix, 3));
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        boolean result = false;
//        int l = matrix.length;// 行
//        int w = matrix[0].length;// 列
//        for (int i = 0; i < l; i++) {
//            // 行
//            if (matrix[i][0] <= target && matrix[i][w - 1] >= target) {
//                for (int j = 0; j < w; j++) {
//                    // 列
//                    if (matrix[0][j] <= target && matrix[l - 1][j] >= target) {
//                        if (matrix[i][j] == target) {
//                            result = true;
//                            break;
//                        }
//                    } else if (matrix[0][j] > target) {
//                        break;
//                    }
//                }
//            } else if (matrix[i][0] > target) {
//                break;
//            }
//        }
//        return result;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
