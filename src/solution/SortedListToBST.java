package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-21 16:25
 */
public class SortedListToBST {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {

        if (Objects.isNull(head)) return null;

        ListNode mid = findMidleNode(head);
        TreeNode node = new TreeNode(mid.val);

        if (head == mid) return node;

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }

    private ListNode findMidleNode(ListNode node) {

        ListNode headOne = node;
        ListNode headTwo = node;
        ListNode prevPtr = null;

        while (headTwo != null && headTwo.next != null) {
            prevPtr = headOne;
            headOne = headOne.next;
            headTwo = headTwo.next.next;
        }

        if (Objects.nonNull(prevPtr)) prevPtr.next = null;

        return headOne;
    }
}
