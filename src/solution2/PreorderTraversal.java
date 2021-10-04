package solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    private static void dfs(List<Integer> list, TreeNode node) {

        if (Objects.isNull(node)) {
            return;
        }
        list.add(node.val);
        dfs(list, node.left);
        dfs(list, node.right);
    }

}
