package leetcode2022.lc01_02;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/9 23:00
 * @ Description
 */
public class LeetCode151 {
    public static void main(String[] args) {
        LeetCode151 lc = new LeetCode151();
        System.out.println(lc.reverseWords("  Bob    Loves  Alice   "));
        System.out.println(lc.reverseWords("Alice does not even like bo"));
    }

    public String reverseWords(String s) {
        String[] strList = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strList.length - 1; i >= 0; i--) {
            if (strList[i].equals("")) {
                continue;
            }
            sb.append(strList[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
