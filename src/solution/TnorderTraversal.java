package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-04-07 19:50
 * <p>
 * 给定一个二叉树，返回它的中序遍历。
 */
public class TnorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> nodeValList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (Objects.nonNull(curr) || !stack.isEmpty()) {

            while (Objects.nonNull(curr)) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nodeValList.add(curr.val);
            curr = curr.right;
        }

        return nodeValList;
    }
}
