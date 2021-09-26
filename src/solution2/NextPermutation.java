/**
 * @(#)NextPermutation.java, 9月 25, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

import java.util.Arrays;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/25 3:41 下午
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3, 2, 0};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        //12|4|3 -> 1324    12546733 -> 12547633   5|6|45321 -> 6123455   56574327111 -> 56574371112   4223351 -> 4232355 225551000-> 250001255

        int index = -1;
        int k = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (j > index) {
                        index = j;
                        k = i;
                    }
                    break;
                }
            }
        }

        if (index != -1) {
            int t = nums[index];
            nums[index] = nums[k];
            nums[k] = t;
        }
        Arrays.sort(nums, index + 1, nums.length);
    }
}