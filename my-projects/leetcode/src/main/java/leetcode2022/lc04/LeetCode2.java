package leetcode2022.lc04;

/**
 * @ Author         zhangHan
 * @ Date           2022/4/2 15:55
 * @ Description
 */
public class LeetCode2 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }
        int temp = 0;
        ListNode res = null;
        ListNode preNode = null;
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode(0);
            if (l1 != null) {
                node.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                node.val += l2.val;
                l2 = l2.next;
            }
            node.val += temp;
            temp = node.val / 10;
            node.val %= 10;
            if (preNode != null) {
                preNode.next = node;
            } else {
                res = node;
            }
            preNode = node;
        }
        if (temp != 0) {
            preNode.next = new ListNode(temp);
        }
        return res;
    }
}



