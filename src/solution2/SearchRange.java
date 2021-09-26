/**
 * @(#)SearchRange.java, 9月 25, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

import java.util.Arrays;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/25 5:00 下午
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(Arrays.toString(searchRange(nums, 0)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int half = (left + right + 1) / 2;
            if (target < nums[half]) {
                right = half - 1;
            } else if (target > nums[half]) {
                left = half + 1;
            } else {
                int i = half, j = half;
                while (i > 0 && nums[i] == nums[i - 1]) {
                    i--;
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}