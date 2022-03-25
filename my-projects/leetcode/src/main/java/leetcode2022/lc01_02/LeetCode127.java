package leetcode2022.lc01_02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/9 23:29
 * @ Description
 */
public class LeetCode127 {
    public static void main(String[] args) {
        LeetCode127 lc = new LeetCode127();
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(lc.ladderLength("hit", "cog", words));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> curStrList = new HashSet<>();
        curStrList.add(beginWord);
        return findStr(curStrList, wordList, 1, endWord);
    }

    public int findStr(Set<String> curStrList, List<String> others, int count, String endWord) {
        if (curStrList.contains(endWord)) {
            return count;
        }
        boolean goNext = false;
        HashSet<String> nextBeginList = new HashSet<>();
        for (String cur : curStrList) {
            for (String str : others) {
                if (distinctOnlyOne(cur, str)) {
                    nextBeginList.add(str);
                    goNext = true;
                }
            }
        }
        List<String> nextOthers = others.stream().filter(e -> !nextBeginList.contains(e)).collect(Collectors.toList());
        if (goNext) {
            return findStr(nextBeginList, nextOthers, count + 1, endWord);
        } else {
            return 0;
        }
    }

    public boolean distinctOnlyOne(String a, String b) {
        int count = 0;
        if (a.equals(b)) {
            return false;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
        }
        return count == 1;
    }
}
