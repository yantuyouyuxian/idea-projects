package leetcode2021;

public class LeetCode1156 {

    public static void main(String[] args) {
        LeetCode1156 lc = new LeetCode1156();
        System.out.println(lc.maxRepOpt1("aabaaabaaaba"));
        System.out.println(lc.maxRepOpt1("abaaaa"));
        System.out.println(lc.maxRepOpt1("aaabbaaa"));
        System.out.println(lc.maxRepOpt1("abcb"));
        System.out.println(lc.maxRepOpt1("aabaaa"));
        System.out.println(lc.maxRepOpt1("abbaca"));
        System.out.println(lc.maxRepOpt1("abc"));
    }

    public int maxRepOpt1(String text) {
        char[] chars = text.toCharArray();
        int[] charCount = new int[26];
        for (int k = 0; k < chars.length; k++) {
            charCount[chars[k] - 'a']++;
        }
        int res = 1;
        for (int i = 0; i < chars.length; ) {
            boolean changed = false;
            int maxLen = 0;
            for (int j = i; j < chars.length; ) {
                if (chars[j] == chars[i]) {
                    maxLen++;
                    j++;
                } else if (j + 1 < chars.length && chars[j + 1] == chars[i]) {
                    if (!changed) {
                        changed = true;
                        maxLen++;
                        j++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (changed && maxLen > charCount[chars[i] - 'a']) maxLen--;
            if (!changed && maxLen < charCount[chars[i] - 'a']) maxLen++;
            res = Math.max(maxLen, res);
            i++;
        }
        return res;
    }
}
