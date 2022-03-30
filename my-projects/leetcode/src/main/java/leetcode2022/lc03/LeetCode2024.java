package leetcode2022.lc03;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/29 21:18
 * @ Description
 */
public class LeetCode2024 {
    public static void main(String[] args) {
        LeetCode2024 lc = new LeetCode2024();
        System.out.println(lc.maxConsecutiveAnswers("TTFF", 2));
        System.out.println(lc.maxConsecutiveAnswers("TFFT", 1));
        System.out.println(lc.maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int max =0;
        max = Math.max(maxConsecutiveAnswers(chars,k,'T'),max);
        max = Math.max(maxConsecutiveAnswers(chars,k,'F'),max);
        return max;
    }

    public int maxConsecutiveAnswers(char[] chars, int k, char c) {
        int i = 0, j = 0, len = chars.length;
        int charCnt = 0;
        int max = 0;
        for (; j < len; j++) {
            if (chars[j] == c) {
                charCnt++;
            }
            while (charCnt > k) {
                if (chars[i] == c) {
                    charCnt--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
