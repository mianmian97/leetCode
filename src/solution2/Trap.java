/**
 * @(#)Trap.java, 9月 26, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

import java.util.Stack;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/26 5:03 下午
 * <p>
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        /**
         * stack
         */
        int sum = 0;
        if (height.length == 0) {
            return sum;
        }
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {

                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distinct = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum += ((min - h) * distinct);
            }
            stack.push(current);
            current++;
        }
        return sum;
//        /**
//         * 动态规划
//         */
//        int sum = 0;
//        int[] maxLeft = new int[height.length];
//        int[] maxRight = new int[height.length];
//
//        for (int i = 1; i < height.length - 1; i++) {
//            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
//        }
//        for (int i = height.length - 2; i > 0; i--) {
//            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
//        }
//        for (int i = 1; i < height.length - 1; i++) {
//            int min = Math.min(maxLeft[i], maxRight[i]);
//            if (min > height[i]) {
//                sum += (min - height[i]);
//            }
//        }
//        return sum;
    }
}