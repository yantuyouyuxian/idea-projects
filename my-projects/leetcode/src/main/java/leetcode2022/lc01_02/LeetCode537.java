package leetcode2022.lc01_02;

/**
 * @ Author       zhangHan
 * @ Date         2022/2/25 20:43
 * @ Description
 */
public class LeetCode537 {
    public static void main(String[] args) {

        LeetCode537 lc = new LeetCode537();
        System.out.println(lc.complexNumberMultiply("1+1i", "1+1i"));
    }

//    num1 = "a+bi", num2 = "x+yi"
//    ax+ayi+bxi-by
//    "1+1i", num2 = "1+1i"

    public String complexNumberMultiply(String num1, String num2) {
        String a1 = num1.substring(0, num1.indexOf("+"));
        String a2 = num1.substring(num1.indexOf("+") + 1, num1.length() - 1);

        String b1 = num2.substring(0,num2.indexOf("+"));
        String b2 = num2.substring(num2.indexOf("+")+1,num2.length()-1);

        int A1 = Integer.parseInt(a1);
        int A2 = Integer.parseInt(a2);

        int B1 = Integer.parseInt(b1);
        int B2 = Integer.parseInt(b2);

        return (A1*B1 - A2*B2) +"+"+ (A1*B2+A2*B1) + "i";

        // 必须写出来
        // 不能看答案
        // 50道

        // 题型：数组，字符串，集合，
        // 双指针：滑动窗口
        // 栈：单调栈（温度题）
        // 队列：优先级队列
        // 二叉树：（容易考），遍历，路径，深度优先，广度优先
        // 二分法，



    }
}

