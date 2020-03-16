package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-14 23:43
 */
public class MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode first = node;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (Objects.nonNull(l1)) {
            node.next = l1;
        }
        if (Objects.nonNull(l2)) {
            node.next = l2;
        }

        return first.next;
    }
}
