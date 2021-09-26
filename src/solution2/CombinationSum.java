/**
 * @(#)CombinationSum.java, 9月 26, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: Zhang Yi
 * @Date: 2021/9/26 3:21 下午
 * <p>
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * <p>
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 */
public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum(candidates, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        int length = candidates.length;
        if (length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        dfs(deque, lists, candidates, target, 0, length);
        return lists;
    }

    private static void dfs(Deque<Integer> deque, List<List<Integer>> lists, int[] candidates, int target, int begin, int length) {
        if (target == 0) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = begin; i < length; i++) {
            deque.addLast(candidates[i]);
            dfs(deque, lists, candidates, target - candidates[i], i, length);
            deque.removeLast();
        }
    }
}