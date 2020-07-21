/**
 * @(#)ReverseKGroup.java, 7月 05, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution;

import java.util.Objects;

/**
 * @Author: Zhang Yi
 * @Date: 2020/7/5 2:34 下午
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(reverseKGroup(node1, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (Objects.isNull(head)) {
            return null;
        }

        ListNode firstNode = new ListNode(-1);
        firstNode.next = head;
        ListNode pre = firstNode;
        ListNode end = firstNode;

        while (Objects.nonNull(end.next)) {
            for (int i = 0; i < k && Objects.nonNull(end); i++) {
                end = end.next;
            }
            if (Objects.isNull(end)) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;

            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }

        return firstNode.next;
    }

    static ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;
        while (Objects.nonNull(curr)) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}