package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Author       zhangHan
 * @ Date         2021/6/5 18:18
 * @ Description
 */
public class LeetCode662 {
    static Integer[] dataList = {1, 3, 2, 5, 3, null, 9};

    public static void main(String[] args) {
        TreeNode root = createNode(1);
        LeetCode662 lt = new LeetCode662();
        System.out.println(lt.widthOfBinaryTree(root));
    }

    static Integer maxWidth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        if (root == null) {
            return 0;
        } else {
            root.val = 1;
            setIndex(root);
            getWidth(Collections.singletonList(root));
            return maxWidth;
        }
    }

    public void setIndex(TreeNode father) {
        if (father.left != null) {
            father.left.val = father.val * 2;
            setIndex(father.left);
        }
        if (father.right != null) {
            father.right.val = father.val * 2 + 1;
            setIndex(father.right);
        }
    }

    public void getWidth(List<TreeNode> nodes) {
        int levWidth = nodes.get(nodes.size() - 1).val - nodes.get(0).val + 1;
        if (levWidth > maxWidth) maxWidth = levWidth;
        List<TreeNode> children = nodes.stream().filter(Objects::nonNull).flatMap(e -> Stream.of(e.left, e.right)).filter(Objects::nonNull).collect(Collectors.toList());
        if (children.size() > 0) {
            getWidth(children);
        }
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

    public static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
        }
    }


    public static void levRead(List<TreeNode> nodes) {
        List<TreeNode> list = new ArrayList<>();
        nodes.forEach(node -> {
            if (null != node) {
                System.out.print(node.val + " ");
                if (node.left != null || node.right != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            } else {
                System.out.print(" null ");
            }
        });
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
