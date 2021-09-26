/**
 * @(#)Trap.java, 9月 26, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/26 5:03 下午
 * <p>
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 3};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        int result = 0;
        int i = 0;
        while (i < height.length - 1) {
            if (height[i] == 0) {
                i++;
                continue;
            }
            boolean b = false;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    for (int k = i + 1; k < j; k++) {
                        result += (height[i] - height[k]);
                    }
                    i = j;
                    b = true;
                    break;
                }
            }
            if (!b) {
                i++;
            }
        }
        return result;
    }
}