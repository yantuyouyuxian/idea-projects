package leetcode2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author       zhangHan
 * @ Date         2021/8/24 20:32
 * @ Description
 */
public class LeetCode417 {

    public static void main(String[] args) {
        LeetCode417 lc = new LeetCode417();
        long start = System.currentTimeMillis();
        System.out.println(lc.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
        System.out.println(lc.pacificAtlantic(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        System.out.println(lc.pacificAtlantic(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(lc.pacificAtlantic_2(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
        System.out.println(lc.pacificAtlantic_2(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        System.out.println(lc.pacificAtlantic_2(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        System.out.println(System.currentTimeMillis() - start);
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        HashSet<Integer> top_left = new HashSet<>();
        HashSet<Integer> bot_right = new HashSet<>();
        for (int j = 0; j < col; j++) {
            top_left.add(j);
            bot_right.add(col * (row - 1) + j);
        }
        for (int i = 0; i < row; i++) {
            top_left.add(i * col);
            bot_right.add(col * i + col - 1);
        }
        fun(top_left, heights);
        fun(bot_right, heights);
        return top_left.stream().filter(bot_right::contains).map(e -> {
            List<Integer> list = new ArrayList<>();
            list.add(e / col);
            list.add(e % col);
            return list;
        }).collect(Collectors.toList());
    }

    //i * col + j = ??????
    //i = ??????/col  j = ??????%col
    //???????????????0 -> row * col - 1
    public void fun(HashSet<Integer> set, int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        HashSet<Integer> tem = new HashSet<>(set);
        while (tem.size() > 0) {
            HashSet<Integer> tt = new HashSet<>();
            for (Integer a : tem) {
                //???
                int i = a / col;
                //???
                int j = a % col;
                if (j + 1 < col) {
                    //???????????????
                    int right = a + 1;
                    if (!set.contains(right)) {
                        if (heights[i][j + 1] >= heights[a / col][a % col]) {
                            tt.add(right);
                        }
                    }
                }
                if (i + 1 < row) {
                    //???????????????
                    int bottom = a + col;
                    if (!set.contains(bottom)) {
                        if (heights[i + 1][j] >= heights[a / col][a % col]) {
                            tt.add(bottom);
                        }
                    }
                }
                if (j - 1 >= 0) {
                    //???????????????
                    int left = a - 1;
                    if (!set.contains(left)) {
                        if (heights[i][j - 1] >= heights[a / col][a % col]) {
                            tt.add(left);
                        }
                    }
                }
                if (i - 1 >= 0) {
                    //???????????????
                    int top = a - col;
                    if (!set.contains(top)) {
                        if (heights[i - 1][j] >= heights[a / col][a % col]) {
                            tt.add(top);
                        }
                    }
                }
            }
            set.addAll(tt);
            tem = tt;
        }
    }


    public List<List<Integer>> pacificAtlantic_2(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] topLeft = new boolean[row][col], botRight = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            //????????????????????????
            dfs(heights, topLeft, i, 0);
            dfs(heights, botRight, i, col - 1);
        }
        for (int j = 0; j < col; j++) {
            //????????????????????????
            dfs(heights, topLeft, 0, j);
            dfs(heights, botRight, row - 1, j);
        }
        //???????????????????????????????????????????????????
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (topLeft[i][j] && botRight[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        //??????????????????????????????????????????
        if (canReach[i][j]) return;
        //???????????????????????????????????????????????????
        canReach[i][j] = true;
        //?????????????????????????????????????????????
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            dfs(heights, canReach, i - 1, j);
        }
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j - 1);
        }
        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
            dfs(heights, canReach, i + 1, j);
        }
        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j + 1);
        }
    }
}
