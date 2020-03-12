package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-10 18:52
 */
public class DiameterOfBinaryTree {

    private int dia = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {

        diameter(root);
        return dia;
    }

    private int diameter(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int left = diameter(node.left);
        int right = diameter(node.right);
        dia = Math.max(dia, left + right + 1);
        return Math.max(left, right);
    }
}
