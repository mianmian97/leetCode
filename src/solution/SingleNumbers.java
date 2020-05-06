package solution;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : zhangyi
 * @Date : 2020-04-29 00:49
 */
public class SingleNumbers {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(singleNumbers(new int[]{1, 2, 5, 2})));
    }

    public static int[] singleNumbers(int[] nums) {

        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
