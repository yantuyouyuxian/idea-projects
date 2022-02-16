package leetcode2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author         zhangHan
 * @ Date           2022/1/17 22:24
 * @ Description
 */
public class LeetCode1220 {

    List<String> data = new ArrayList<String>() {
        private static final long serialVersionUID = 7648487309849573574L;

        {
            add("a");// ->e         (0) -> (1)
            add("e");// ->a / i     (1) -> (0),(2)
            add("i");// ->a/e/o/u   (2) -> (0),(1),(3),(4)
            add("o");// ->i/u       (3) -> (2),(4)
            add("u");// ->a         (4) -> (0)
        }
    };
    List<Integer> aReached = Collections.singletonList(1);
    List<Integer> eReached = Arrays.asList(0, 2);
    List<Integer> iReached = Arrays.asList(0, 1, 3, 4);
    List<Integer> oReached = Arrays.asList(2, 4);
    List<Integer> uReached = Collections.singletonList(0);

    Map<Integer, List<Integer>> reachedMap = new HashMap<Integer, List<Integer>>() {
        private static final long serialVersionUID = 576066435711727769L;

        {
            put(0, aReached);
            put(1, eReached);
            put(2, iReached);
            put(3, oReached);
            put(4, uReached);
        }
    };
    int[][] reached = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0},
    };

//    public int countVowelPermutation(int n) {
//        long mod = 1000000007;
//        long[] arr_1 = new long[]{1, 1, 1, 1, 1};
//        long[] arr_2 = new long[5];
//        for (int i = 2; i <= n; i++) {
//            arr_2[0] = arr_1[1];// 0 可以放在 1 前面
//            arr_2[1] = (arr_1[0] + arr_1[2]) % mod;// 1 可以放在 0 和 2 前面
//            arr_2[2] = (arr_1[0] + arr_1[1] + arr_1[3] + arr_1[4]) % mod;// 2 可以放在0，1，3，4前面
//            arr_2[3] = (arr_1[2] + arr_1[4]) % mod; // 3 可以放在2，4前面
//            arr_2[4] = arr_1[0];// 4可以放在 0 前面
//            System.arraycopy(arr_2, 0, arr_1, 0, 5);
//        }
//        long res = 0;
//        for (int i = 0; i < arr_1.length; i++) {
//            res = (res + arr_1[i]) % mod;
//        }
//        return (int) res;
//    }

    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long an, en, in, on, un;
        for (int j = 2; j <= n; j++) {
            an = e;
            en = (a + i) % mod;
            in = (a + e + o + u) % mod;
            on = (i + u) % mod;
            un = a;

            a = an;
            e = en;
            i = in;
            o = on;
            u = un;
        }
        return (int) ((a + e + i + o + u) % mod);
    }

    public static void main(String[] args) {
        LeetCode1220 lc = new LeetCode1220();
        System.out.println(lc.countVowelPermutation(2));
        System.out.println(lc.countVowelPermutation(5));
    }


    public List<Integer> getReached(int i) {
        return reachedMap.get(i);
    }
}
