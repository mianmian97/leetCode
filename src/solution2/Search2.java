package solution2;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Search2 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 3, 4, 5, 6, 7};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {

        return helper(nums, target) - helper(nums, target - 1);
    }

    public static int helper(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
