package solution2;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        dfs(nums, lists, new ArrayDeque<>(), 0, nums.length, used);
        return lists;
    }

    public static void dfs(int[] nums, List<List<Integer>> lists, Deque<Integer> deque, int index, int length, boolean[] used) {

        if (index == length) {
            lists.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            deque.addLast(nums[i]);
            used[i] = true;
            dfs(nums, lists, deque, index + 1, length, used);
            used[i] = false;
            deque.removeLast();
        }

    }
}
