package solution2;

import java.util.*;

public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 0,3};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);

        dfs(nums, lists, new ArrayDeque<>(), 0, nums.length, used);
        return lists;
    }

    public static void dfs(int[] nums, List<List<Integer>> lists, Deque<Integer> deque, int index, int length, boolean[] used) {

        if (index == length) {
            lists.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
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
