package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-21 17:48
 */
public class MinDepth {

    public int minDepth(TreeNode root) {

        if (Objects.isNull(root)) return 0;

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) return 1;

        int minHeight = Integer.MAX_VALUE;

        if (Objects.nonNull(root.left)) {
            minHeight = Math.min(minDepth(root.left), minHeight);
        }
        if (Objects.nonNull(root.right)) {
            minHeight = Math.min(minDepth(root.right), minHeight);
        }

        return minHeight + 1;
    }

}
