/**
 * @(#)RemoveElement.java, 9月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution;

import java.util.Objects;

/**
 * @Author: Zhang Yi
 * @Date: 2020/9/12 12:15 下午
 */
public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}