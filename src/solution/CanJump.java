package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-04-17 20:53
 */
public class CanJump {

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{3, 5, 0, 0, 0}));
    }

    public static boolean canJump(int[] nums) {

        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
