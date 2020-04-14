package solution;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author : zhangyi
 * @Date : 2020-04-14 15:07
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        //迭代
        Queue<TreeNode> valList = new LinkedList<>();
        valList.add(root);
        valList.add(root);
        while (!valList.isEmpty()) {

            TreeNode leftNode = valList.poll();
            TreeNode rightNode = valList.poll();


            if (Objects.isNull(leftNode) && Objects.isNull(rightNode)) continue;

            if (Objects.isNull(leftNode) || Objects.isNull(rightNode)) return false;

            if (leftNode.val != rightNode.val) return false;

            valList.add(leftNode.left);
            valList.add(rightNode.right);
            valList.add(leftNode.right);
            valList.add(rightNode.left);
        }

        return true;

        //递归
        /*if (Objects.isNull(root)) return false;
        return check(root.left, root.right);*/
    }

    public boolean check(TreeNode node1, TreeNode node2) {

        if (Objects.isNull(node1) && Objects.isNull(node2)) return true;

        if (Objects.isNull(node1) || Objects.isNull(node2)) return false;

        if (node1.val != node2.val) return false;

        return check(node1.left, node2.right) && check(node1.right, node2.left);
    }
}
