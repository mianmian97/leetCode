/**
 * @(#)AverageOfLevels.java, 9月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Zhang Yi
 * @Date: 2020/9/12 12:44 下午
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);

        List<Double> averList = new ArrayList<>();
        for (int i = 0; i < counts.size(); i++) {
            averList.add(sums.get(i) / counts.get(i));
        }
        return averList;
    }

    private void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (Objects.isNull(root)) {
            return;
        }
        if (level < counts.size()) {
            counts.set(level, counts.get(level) + 1);
            sums.set(level, sums.get(level) + root.val);
        } else {
            counts.add(level, 1);
            sums.add(root.val * 1.0);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}