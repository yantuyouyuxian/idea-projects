package leetcode2021;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/2 18:50
 * @ Description
 */
public class LeetCodeOffer64 {

    int res = 0;

    public static void main(String[] args) {
        LeetCodeOffer64 lc = new LeetCodeOffer64();
        System.out.println(lc.sumNums(10));
        System.out.println(lc.function_1(10));
    }

    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumNums(n - 1);
        }
    }

    public int function_1(int n) {
        boolean flag = n >= 1 && function_1(n - 1) > 0;
//        if (n >= 1) {
//            function_1(n - 1);
//        }
        res += n;
        return res;
    }

    public int function_2(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;
    }


}
