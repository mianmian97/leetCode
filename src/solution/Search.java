package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-27 00:14
 */
public class Search {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 3};
        System.out.println(search(arr, 3));
    }

    public static int search(int[] nums, int target) {

        if (Objects.isNull(nums) || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }

        return -1;
    }
}
