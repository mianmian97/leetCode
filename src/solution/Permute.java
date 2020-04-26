package solution;

import java.util.*;

/**
 * @Author : zhangyi
 * @Date : 2020-04-25 22:51
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length == 0) {
            return result;
        }

        int len = nums.length;
        boolean[] has = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<Integer>();

        dfs(nums, result, len, 0, path, has);

        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int len, int height, Deque<Integer> path, boolean[] has) {

        if (height == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (has[i]) continue;
            path.addLast(nums[i]);
            has[i] = true;
            dfs(nums, result, len, height + 1, path, has);
            path.removeLast();
            has[i] = false;
        }
    }


}
