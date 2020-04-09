package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-04-07 20:16
 * <p>
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> nodeValList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (Objects.nonNull(curr) || !stack.isEmpty()) {

            while (Objects.nonNull(curr)) {
                stack.push(curr);
                nodeValList.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }

        return nodeValList;

    }
}
