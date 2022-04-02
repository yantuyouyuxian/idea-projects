package leetcode2022.lc04;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author         zhangHan
 * @ Date           2022/4/2 20:07
 * @ Description
 */
public class LeetCode3 {

    public static void main(String[] args) {
        LeetCode3 lc = new LeetCode3();
        System.out.println(lc.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int h = 0, i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                max = Math.max(set.size(), max);
                while (chars[h] != chars[i]) {
                    set.remove(chars[h]);
                    h++;
                }
                h++;
            }
            set.add(chars[i]);
        }
        return Math.max(set.size(), max);
    }
}
