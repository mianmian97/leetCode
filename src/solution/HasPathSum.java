package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-21 18:07
 */
public class HasPathSum {


    public boolean hasPathSum(TreeNode root, int sum) {

        if (Objects.isNull(root)) return false;

        sum -= root.val;

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) return sum == 0;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }


}
