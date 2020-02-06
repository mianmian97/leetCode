package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-02-01 20:45
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {3, 3};
        int target = 6;
        int[] vars = twoSum(nums, target);
        System.out.println(vars[0] + "," + vars[1]);
    }

    public static int[] twoSum(int[] nums, int target) {


        int[] arr = new int[2];

        //暴力法
        /*for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }*/

        //HashMap索引
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (Objects.nonNull(map.get(diff))) {
                arr[0] = i;
                arr[1] = map.get(diff);
                return arr;
            }
            map.put(nums[i], i);
        }
        return arr;
    }
}
