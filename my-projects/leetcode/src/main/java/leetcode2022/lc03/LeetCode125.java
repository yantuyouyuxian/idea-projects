package leetcode2022.lc03;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/25 22:56
 * @ Description
 */
public class LeetCode125 {
    public static void main(String[] args) {
        LeetCode125 lc = new LeetCode125();
        System.out.println(lc.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(lc.isPalindrome("race a car"));
        System.out.println(lc.isPalindrome(".,"));
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        boolean res = true;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(chars[l])) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(chars[r])) {
                r--;
            }
            if (l > r) {
                break;
            }
            if (Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])) {
                res = false;
                break;
            }
            l++;
            r--;
        }
        return res;
    }
}
