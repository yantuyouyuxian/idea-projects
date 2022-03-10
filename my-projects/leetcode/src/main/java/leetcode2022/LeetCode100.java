package leetcode2022;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/10 10:45
 * @ Description
 */
public class LeetCode100 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
