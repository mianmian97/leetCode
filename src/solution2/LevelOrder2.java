package solution2;

import java.util.*;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class LevelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (Objects.nonNull(node.left)) {
                    queue.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
