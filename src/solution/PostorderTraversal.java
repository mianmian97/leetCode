package solution;

import java.util.*;

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
                nodeValList.add(curr.val);
                curr = curr.right;
            }
            curr = stack.pop();
            curr = curr.left;
        }

        Collections.reverse(nodeValList);
        return nodeValList;
    }

}
