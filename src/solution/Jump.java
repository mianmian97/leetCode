package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-05-04 23:47
 */
public class Jump {

    public static int jump(int[] nums) {

        int position = nums.length - 1;
        int step = 0;

        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] > position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
