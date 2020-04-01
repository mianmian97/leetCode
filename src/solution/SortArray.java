package solution;

import java.util.Arrays;

/**
 * @Author : zhangyi
 * @Date : 2020-03-31 15:00
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class SortArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 5, 8, 3, 6, 8, 0, 0})));
    }

    public static int[] sortArray(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int t = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = t;
        }

        return nums;
    }
}
