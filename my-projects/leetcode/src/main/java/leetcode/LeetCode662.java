package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author       zhangHan
 * @ Date         2021/6/5 18:18
 * @ Description
 */
public class LeetCode662 {
    static Integer[] dataList = {1, 3, null, 5, 3};
    static List<TreeNode> nodes = new ArrayList<>();
    static Integer wid;

    public static int widthOfBinaryTree(TreeNode root) {
        wid = 0;
        nodes.add(root);
        levRead(nodes);
        return wid;
    }

    public static void main(String[] args) {
        wid = 0;
        TreeNode root = createNode(1);
//        nodes.add(root);

        preRead(root);
        System.out.println();
        midRead(root);
        System.out.println();
        afterRead(root);
        System.out.println();

//        levRead(nodes);
//        System.out.println(wid);
        System.out.println(widthOfBinaryTree(root));

    }

    public static void preRead(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preRead(node.left);
            preRead(node.right);
        }
    }

    public static void midRead(TreeNode node) {
        if (node != null) {
            midRead(node.left);
            System.out.print(node.val + " ");
            midRead(node.right);
        }
    }

    public static void afterRead(TreeNode node) {
        if (node != null) {
            afterRead(node.left);
            afterRead(node.right);
            System.out.print(node.val + " ");
        }
    }

    public static void levRead(List<TreeNode> nodes) {
        List<TreeNode> list = new ArrayList<>();
        int i = -1, j = -1;
        for (int k = 0; k < nodes.size(); k++) {
            TreeNode node = nodes.get(k);
            if (null != node) {
                if (i == -1) {
                    i = k;
                }
                j = k;
                System.out.print(node.val + " ");
                if (node.left != null || node.right != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            } else {
                System.out.print(" null ");
            }
        }
        if (j - i + 1 > wid) {
            wid = j - i + 1;
        }
//        nodes.forEach(node -> {
//            if (null != node) {
//                System.out.print(node.val + " ");
//                if (node.left != null || node.right != null) {
//                    list.add(node.left);
//                    list.add(node.right);
//                }
//            } else {
//                System.out.print(" null ");
//            }
//        });
        System.out.println();
        if (list.size() > 0) {
            levRead(list);
        }
    }

    public static TreeNode createNode(int index) {
        if (index <= dataList.length && dataList[index - 1] != null) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = dataList[index - 1];
            treeNode.left = createNode(index * 2);
            treeNode.right = createNode(index * 2 + 1);
            return treeNode;
        } else {
            return null;
        }
    }


}

class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
