package solution2;

import java.util.Objects;

public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return dfs(root.left, root.right);

    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        }
        if (Objects.nonNull(left) && Objects.nonNull(right) && left.val == right.val) {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
        return false;
    }
}
