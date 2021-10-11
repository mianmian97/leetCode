package solution2;

import java.util.Objects;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode node = reverseList(node1);
        System.out.println(node);
    }

    public static ListNode reverseList(ListNode head) {

        if (Objects.isNull(head)) {
            return head;
        }

        ListNode pre = head;
        ListNode node = head.next;
        while (Objects.nonNull(node)) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        head.next = null;
        return pre;
    }
}
