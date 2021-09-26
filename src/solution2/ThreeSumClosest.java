/**
 * @(#)ThreeSumClosest.java, 9月 25, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/25 11:34 上午
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int start = 0; start < nums.length - 1; start++) {

            int i = start + 1;
            int end = nums.length - 1;
            while (i < end) {
                int sum = nums[start] + nums[end] + nums[i];
                result = Math.abs(result - target) > Math.abs(sum - target) ? sum : result;

                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    i++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }
}