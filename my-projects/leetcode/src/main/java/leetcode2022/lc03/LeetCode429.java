package leetcode2022.lc03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode2022.Node;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/13 0:10
 * @ Description
 */
public class LeetCode429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        levelFun(Collections.singletonList(root), result);
        return result;
    }

    public void levelFun(List<Node> levelNodes, List<List<Integer>> result) {
        if (levelNodes.size() == 0) return;
        List<Node> nextLevelNodes = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (Node node : levelNodes) {
            if(node != null){
                values.add(node.val);
                nextLevelNodes.addAll(node.children);
            }
        }
        if(values.size()>0){
            result.add(values);
        }
        levelFun(nextLevelNodes, result);
    }

}
