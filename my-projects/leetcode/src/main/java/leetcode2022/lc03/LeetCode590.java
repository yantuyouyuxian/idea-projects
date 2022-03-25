package leetcode2022.lc03;

import java.util.ArrayList;
import java.util.List;

import leetcode2022.lc01_02.Node;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/12 22:40
 * @ Description
 */
public class LeetCode590 {

    public static void main(String[] args) {

    }


    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
//        postFun(root, result);

        return result;
    }


    public void postFun(Node root, List<Integer> result) {
        if (root == null) return;
        if (root.children != null && root.children.size() > 0) {
            for (Node child : root.children) {
                postFun(child, result);
            }
        }
        result.add(root.val);
    }

}
