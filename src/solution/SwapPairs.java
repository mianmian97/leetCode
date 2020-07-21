/**
 * @(#)SwapPairs.java, 7月 05, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution;

import java.util.Objects;

/**
 * @Author: Zhang Yi
 * @Date: 2020/7/5 2:02 下午
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(swapPairs(node1));
    }

    public static ListNode swapPairs(ListNode head) {

        if (Objects.isNull(head)) {
            return null;
        }

        ListNode firstNode = new ListNode(-1);
        firstNode.next = head;
        ListNode pre = firstNode;
        ListNode index = head;
        ListNode next = head.next;

        while (Objects.nonNull(next)) {
            pre.next = index.next;
            index.next = next.next;
            next.next = index;

            pre = index;
            index = index.next;
            if (Objects.isNull(index)) {
                break;
            }
            next = index.next;
        }

        return firstNode.next;
    }
}