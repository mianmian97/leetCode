package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-05-07 18:42
 */
public class IsSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (Objects.isNull(s)) return false;
        if (Objects.isNull(t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {

        if (Objects.isNull(s) && Objects.isNull(t)) return true;
        if (Objects.isNull(s) || Objects.isNull(t)) return false;

        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
