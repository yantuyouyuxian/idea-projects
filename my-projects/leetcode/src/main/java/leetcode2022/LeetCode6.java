package leetcode2022;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/1 21:35
 * @ Description
 */
public class LeetCode6 {
    public static void main(String[] args) {
        LeetCode6 lc = new LeetCode6();
        String str = "PAYPALISHIRING";
        int rows = 2;
        System.out.println(lc.convert(str, rows));
    }

    /**
     * 1234567890
     * 每组2n-2个数
     * <p>
     * 1 - 2n-2         1
     * 2n-1 - 4n-4      2
     * 4n-3 - 6n-6      3
     * <p>
     * 1     7       13
     * 2   6 8    12 14     18
     * 3 5   9  11   15  17
     * 4     10      16
     * <p>
     * 1,  2n-1, 4n-3, (2n-2)
     * 2 6, 8 12, 14 18
     * 3 5, 9 11,
     * 4,  4+
     */

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        int perGroup = numRows * 2 - 2;
        int groupCount = length / perGroup + (length % perGroup == 0 ? 0 : 1);
        int newLen = groupCount * perGroup;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                // 每组的第一个字母
                for (int j = 1; j <= groupCount; j++) {
                    int index = (j - 1) * perGroup + 1;
                    int charIndex = index - 1;
                    if (charIndex < chars.length) {
                        sb.append(chars[charIndex]);
                    }
                }
            } else if (i == numRows) {
                // 每组的第numRows个数
                for (int j = 1; j <= groupCount; j++) {
                    int index = (j - 1) * perGroup + 1 + numRows - 1;
                    int charIndex = index - 1;
                    if (charIndex < chars.length) {
                        sb.append(chars[charIndex]);
                    }
                }
            } else {
                for (int j = 1; j <= groupCount; j++) {
                    int index1 = (j - 1) * perGroup + 1 + i - 1;
                    int index2 = (j - 1) * perGroup + 1 + j * perGroup + 1 - index1;
                    int charIndex1 = index1 - 1;
                    int charIndex2 = index2 - 1;
                    if (charIndex1 < chars.length) {
                        sb.append(chars[charIndex1]);
                    }
                    if (charIndex2 < chars.length) {
                        sb.append(chars[charIndex2]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
