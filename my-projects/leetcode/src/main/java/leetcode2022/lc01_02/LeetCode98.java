package leetcode2022.lc01_02;

import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/3 0:40
 * @ Description
 */
public class LeetCode98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 2;
        TreeNode left = new TreeNode();
        left.val = 1;
        TreeNode right = new TreeNode();
        right.val = 3;

        root.left = left;
        root.right = right;
        LeetCode98 lc = new LeetCode98();
        System.out.println(lc.isValidBST(root));
    }

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

//    public boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        leftView(root, list);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) < list.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public void leftView(TreeNode root, List<Integer> nums) {
        if (root != null) {
            leftView(root.left, nums);
            nums.add(root.val);
            leftView(root.right, nums);
        }
    }

}
