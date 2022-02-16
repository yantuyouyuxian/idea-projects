package leetcode2021;

public class LeetCodeOffer67 {

    public static void main(String[] args) {
        System.out.println(new LeetCodeOffer67().strToInt("-91283472332"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int index = 1, sign = 1, res = 0;
        int BOUNDARY = Integer.MAX_VALUE / 10;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            index = 0;
        }
        for (int i = index; i < c.length; i++) {
            if (c[i] < '0' || c[i] > '9') {
                break;
            }
            if (res > BOUNDARY || (res == BOUNDARY && c[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE * sign : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[i] - '0');
        }
        return res * sign;
    }
}
