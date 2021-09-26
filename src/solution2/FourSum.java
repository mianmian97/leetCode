/**
 * @(#)FourSum.java, 9月 25, 2021.
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
 * @Date: 2021/9/25 11:56 上午
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] + nums[1] + nums[2] + nums[3] > target ||
                nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4] < target) {
            return result;
        }

        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int end = length - 1;
                while (k < end) {
                    if (nums[i] + nums[j] + nums[k] + nums[end] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[end]));
                        while (k < end && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        k++;
                        while (k < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    } else if (nums[i] + nums[j] + nums[k] + nums[end] > target) {
                        end--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}