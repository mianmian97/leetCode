package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-14 14:54
 */
public class IsSameTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return isSame(p, q);

    }

    public boolean isSame(TreeNode p, TreeNode q) {

        if (Objects.isNull(p) && Objects.isNull(q)) return true;

        if (Objects.isNull(p) || Objects.isNull(q)) return false;

        if (p.val != q.val) return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
