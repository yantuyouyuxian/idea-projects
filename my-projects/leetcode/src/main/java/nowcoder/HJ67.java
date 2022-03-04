package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/3 20:40
 * @ Description
 */
public class HJ67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            List<Float> nums = new ArrayList<>();
            for (String str : sc.nextLine().split(" ")) {
                nums.add(Float.parseFloat(str));
            }
            int target = 24;
            System.out.println(valid(nums, target));
        }
    }

    public static boolean valid(List<Float> list, int target) {
        boolean flag = false;
        if (list.size() == 2) {
            Float a = list.get(0);
            Float b = list.get(1);
            List<Float> possible = getTwoNumRes(a, b);
            for (Float value : possible) {
                if (value == target) {
                    flag = true;
                    break;
                }
            }
        } else {
            int len = list.size();
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    Float a = list.get(i);
                    Float b = list.get(j);
                    List<Float> possibleValue = getTwoNumRes(a, b);
                    for (Float integer : possibleValue) {
                        ArrayList<Float> nextList = new ArrayList<>();
                        for (int k = 0; k < list.size(); k++) {
                            if (k != i && k != j) {
                                nextList.add(list.get(k));
                            }
                        }
                        nextList.add(integer);
                        if (valid(nextList, target)) {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static List<Float> getTwoNumRes(Float a, Float b) {
        List<Float> values = Arrays.asList(a + b, a - b, b - a, a * b);
        List<Float> res = new ArrayList<>(values);
        if (a != 0) {
            res.add(b / a);
        }
        if (b != 0) {
            res.add(a / b);
        }
        return res;
    }
}
