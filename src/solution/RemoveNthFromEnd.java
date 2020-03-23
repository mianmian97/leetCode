package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-23 14:19
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        removeNthFromEnd(node, 1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "," + next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;

        while (n >= 0) {
            end = end.next;
            n--;
        }
        while (Objects.nonNull(end.next)) {
            end = end.next;
            start = start.next;
        }
        start.next = start.next.next;

        return pre.next;
    }
}
