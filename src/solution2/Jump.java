package solution2;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Jump {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int result = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {

            int maxIndex = 0;
            for (int i = start; i < end; i++) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
            start = end;
            end = maxIndex + 1;
            result++;
        }
        return result;
    }
}
