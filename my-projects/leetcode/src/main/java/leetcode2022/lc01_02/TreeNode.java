package leetcode2022.lc01_02;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/3 0:40
 * @ Description
 */
class TreeNode {
    int val;
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
