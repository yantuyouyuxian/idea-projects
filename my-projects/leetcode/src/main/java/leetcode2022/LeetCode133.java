package leetcode2022;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/3 21:41
 * @ Description
 */
public class LeetCode133 {

    public static void main(String[] args) {

    }

    private HashMap<Integer, Node> nodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        Node result = new Node(node.val, new ArrayList<>());
        nodeMap.put(node.val, result);
        for (Node neighbor : node.neighbors) {
            result.neighbors.add(cloneGraph(neighbor));
        }
        return result;
    }
}
