package solution2;

import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 0, 0, 1};
        System.out.println(findRepeatNumber(array));
    }

    public static int findRepeatNumber(int[] nums) {

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[++i]) {
                return nums[i];
            }
        }
        return -1;
    }
}
