package leetcode2022.lc04;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/4/1 12:10
 * @ Description
 */
public class LeetCode728 {
    public static void main(String[] args) {

    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(function(i)){
                res.add(i);
            }
        }
        return res;
    }

    public boolean function(int num) {
        int tem = num;
        while (tem > 0) {
            int var = tem % 10;
            if (var == 0 || num % var != 0) {
                return false;
            }
            tem /= 10;
        }
        return true;
    }
}
