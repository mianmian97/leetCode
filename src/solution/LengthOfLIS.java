package solution;

import java.util.Arrays;

/**
 * @Author : zhangyi
 * @Date : 2020-03-14 22:47
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class LengthOfLIS {

    public static void main(String[] args) {

        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
