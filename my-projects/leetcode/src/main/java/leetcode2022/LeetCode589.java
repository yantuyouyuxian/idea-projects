package leetcode2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/10 10:36
 * @ Description
 */
public class LeetCode589 {
    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderFun(result, root);
        return result;
    }

    public void preOrderFun(List<Integer> result, Node node) {
        if (node != null) {
            result.add(node.val);
            for (Node child : node.children) {
                preOrderFun(result, child);
            }
        }
    }

}
