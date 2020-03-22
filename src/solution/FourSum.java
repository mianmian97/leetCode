package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-21 23:53
 */
public class FourSum {

    public static void main(String[] args) {

        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int k = 0; k < length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            if (nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3] > target) return result;
            if (nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4] < target) return result;
            for (int i = k + 1; i < length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;
                int j = i + 1;
                int h = length - 1;
                if (nums[k] + nums[i] + nums[j] + nums[j + 1] > target) continue;
                if (nums[h] + nums[h - 1] + nums[h - 1] + nums[h - 3] < target) continue;

                while (j < h) {
                    int num = nums[k] + nums[i] + nums[j] + nums[h];
                    if (num == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) j++;
                        h--;
                        while (j < h && nums[h] == nums[h + 1]) h--;
                    } else if (num > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
