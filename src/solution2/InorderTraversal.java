package solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    private static void dfs(List<Integer> list, TreeNode node) {

        if (Objects.isNull(node)) {
            return;
        }
        dfs(list, node.left);
        list.add(node.val);
        dfs(list, node.right);
    }
}
