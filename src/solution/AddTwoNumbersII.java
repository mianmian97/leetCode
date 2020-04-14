package solution;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-04-14 13:23
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class AddTwoNumbersII {

    public static void main(String[] args) {

        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        System.out.println(addTwoNumbers(l11, l21));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return this.val + "->" + this.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (Objects.nonNull(l1)) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (Objects.nonNull(l2)) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode firstNode = null;
        int addNum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            int num1 = 0, num2 = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                num2 = stack2.pop();
            }
            int num = num1 + num2 + addNum;

            ListNode node = new ListNode(num % 10);
            node.next = firstNode;
            addNum = num / 10;

            firstNode = node;
        }

        if(addNum != 0){
            ListNode node = new ListNode(addNum);
            node.next = firstNode;
            firstNode = node;
        }

        return firstNode;
    }
}
