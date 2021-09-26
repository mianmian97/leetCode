/**
 * @(#)RemoveDuplicates.java, 9月 25, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

import java.util.Arrays;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/25 3:14 下午
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums) + "," + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}