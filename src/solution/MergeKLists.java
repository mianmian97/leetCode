package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-31 19:49
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (Objects.isNull(lists) || lists.length == 0) {
            return null;
        }

        int len = lists.length;
        while (len > 1) {
            int i;
            for (i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
            }
            if (len % 2 != 0) {
                lists[i] = lists[len - 1];
                len++;
            }
            len /= 2;
        }
        return lists[0];

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
