package solution2;

import java.util.Objects;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class IsSymmetric2 {

    public boolean isSymmetric(TreeNode root) {

        if (Objects.isNull(root)) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        }
        if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
