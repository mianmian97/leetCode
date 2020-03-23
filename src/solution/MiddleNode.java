package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-23 11:24
 * <p>
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {

        //单指针法
        /*int length = 0;
        ListNode node = head;
        while (Objects.nonNull(node.next)) {
            length++;
            node = node.next;
        }

        int middle = (length + 1) / 2;
        for (int i = 0; i < middle; i++) {
            head = head.next;
        }

        return head;*/

        //快慢指针法
        ListNode fast = head;
        ListNode slow = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
