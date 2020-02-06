package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-02-06 18:04
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode list1Node1 = new ListNode(2);
        ListNode list1Node2 = new ListNode(4);
        ListNode list1Node3 = new ListNode(3);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        ListNode list2Node1 = new ListNode(5);
        ListNode list2Node2 = new ListNode(6);
        ListNode list2Node3 = new ListNode(5);
        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;

        ListNode node = addTwoNumbers(list1Node1, list2Node1);
        System.out.println(node);
        while (Objects.nonNull(node)) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val:" + val + " nextNode:" + next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int num = 0;
        int addNum = 0;

        ListNode listNode = new ListNode(num);
        ListNode firstNode = listNode;

        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {

            int num1 = 0;
            int num2 = 0;

            if (Objects.nonNull(l1)) {
                num1 = l1.val;
                l1 = l1.next;

            }
            if (Objects.nonNull(l2)) {
                num2 = l2.val;
                l2 = l2.next;
            }

            ListNode numNode = new ListNode((num1 + num2 + addNum) % 10);
            listNode.next = numNode;
            listNode = numNode;

            addNum = (num1 + num2 + addNum) / 10;
        }

        if (addNum != 0) {
            listNode.next = new ListNode(addNum);
        }

        return firstNode.next;
    }

}
