package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-04-07 20:28
 */
public class PostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> nodeValList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (Objects.nonNull(curr) || !stack.isEmpty()) {

            while (Objects.nonNull(curr)) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }

        return nodeValList;
    }

}
