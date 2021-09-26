/**
 * @(#)SearchInsert.java, 9月 25, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/25 5:29 下午
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3,6,7,9};
        System.out.println(searchInsert(nums, 8));
    }

    public static int searchInsert(int[] nums, int target) {

        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int half = (left + right + 1) / 2;
            if (target == nums[half] ){
                return half;
            }
            if (target < nums[half]) {
                right = half - 1;
            } else {
                left = half + 1;
            }
        }
        return left;
    }
}