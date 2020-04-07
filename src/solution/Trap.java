package solution;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-04-06 23:05
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{2, 1, 0, 2}));
    }

    public static int trap(int[] height) {

        /**
         * Stack
         */
        if (Objects.isNull(height) || height.length == 0) {
            return 0;
        }

        int trap = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cur = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    trap += (Math.min(height[stackTop], height[i]) - height[cur]) * (i - stackTop - 1);
                }
            }
            stack.push(i);
        }
        return trap;

        /**
         * 动态规划
         */
        /*int trap = 0;
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (min > height[i]) {
                trap += min - height[i];
            }
        }
        return trap;*/

    }
}
