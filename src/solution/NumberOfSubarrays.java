package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-21 15:44
 */
public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {

        if (Objects.isNull(nums) || nums.length == 0 || k > nums.length) return 0;

        int left = 0, right = 0, count = 0, result = 0, preEven = 0;

        while (right < nums.length) {

            if (count < k) {
                count += nums[right++] & 1;
            }
            if (count == k) {

                preEven = 0;
                while (count == k) {
                    result++;
                    if ((nums[left++] & 1) != 0) count--;
                    preEven++;
                }
            } else {
                result += preEven;
            }
        }

        return result;
    }
}
