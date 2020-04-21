package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-21 17:28
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {

        if(Objects.isNull(root)) return true;
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {

        if (Objects.isNull(root)) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
