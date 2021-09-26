/**
 * @(#)ThreeSum.java, 9月 25, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/25 10:15 上午
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }

        for (int start = 0; start < nums.length - 1; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            int i = start + 1;
            int end = nums.length - 1;
            while (i < end) {
                if (0 < nums[start] + nums[end] + nums[i]) {
                    end--;
                } else if (0 > nums[start] + nums[end] + nums[i]) {
                    i++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[i]);
                    list.add(nums[end]);
                    result.add(list);
                    while (i < end && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    i++;
                    end--;
                }
            }
        }
        return result;
    }
}