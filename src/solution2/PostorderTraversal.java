package solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    private static void dfs(List<Integer> list, TreeNode node) {

        if (Objects.isNull(node)) {
            return;
        }
        dfs(list, node.left);
        dfs(list, node.right);
        list.add(node.val);
    }
}
