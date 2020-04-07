package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-04-06 23:05
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {

        /*int i = 0;
        while (height[i] == 0) {
            i++;
        }

        Stack<Integer> stack = new Stack<>();
        int trap = 0;

        while (i < height.length) {

            int hei = height[i];
            while (height[i] > height[i + 1]) {
                stack.push(height[i]);
                i++;
            }

            hei = Math.min(hei, height[i + 1]);
            while (!stack.empty()) {
                trap += hei - stack.pop();
            }
            i++;
        }

        return trap;*/

        /**
         * 动态规划
         */
        int trap = 0;
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
        return trap;

    }
}
