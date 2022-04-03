package leetcode2022.lc04;

/**
 * @ Author         zhangHan
 * @ Date           2022/4/3 15:40
 * @ Description
 */
public class LeetCode9 {
    public static void main(String[] args) {
        LeetCode9 lc = new LeetCode9();

    }
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        return str.contentEquals(sb.reverse());
    }
}
