/**
 * @(#)FindMedianSortedArrays.java, 9月 24, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/24 5:03 下午
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;

        int start1 = 0, start2 = 0;
        int left = -1, right = -1;
        for (int i = 0; i < length / 2 + 1; i++) {
            left = right;
            if (start1 < length1 && (start2 >= length2 || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        return length % 2 == 0 ? (left + right) / 2D : right;

    }
}