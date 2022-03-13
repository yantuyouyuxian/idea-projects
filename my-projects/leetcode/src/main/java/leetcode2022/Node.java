package leetcode2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/3 21:41
 * @ Description
 */
//public class Node {
//    public int val;
//    public List<Node> neighbors;
//    public Node() {
//        val = 0;
//        neighbors = new ArrayList<>();
//    }
//    public Node(int _val) {
//        val = _val;
//        neighbors = new ArrayList<>();
//    }
//    public Node(int _val, ArrayList<Node> _neighbors) {
//        val = _val;
//        neighbors = _neighbors;
//    }
//}


public class Node {
    public int val;
    public List<Node> children;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
