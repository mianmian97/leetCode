/**
 * @(#)FindLength.java, 7月 01, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution;

import java.util.Objects;

/**
 * @Author: Zhang Yi
 * @Date: 2020/7/1 1:13 下午
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class FindLength {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public static int findLength(int[] A, int[] B) {

        int maxLength = 0;
        if (Objects.isNull(A) || Objects.isNull(B) || A.length == 0 || B.length == 0) {
            return maxLength;
        }
        int[][] array = new int[A.length + 1][B.length + 1];

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = 0;
                }
                maxLength = Math.max(maxLength, array[i][j]);
            }
        }
        return maxLength;
    }
}