package solution2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class LevelOrder3 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.addLast(root);
        linkedList.addLast(null);
        boolean isLeft = true;

        LinkedList<Integer> list = new LinkedList<>();
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.poll();
            if (Objects.nonNull(node)) {
                if (isLeft) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (Objects.nonNull(node.left)) {
                    linkedList.addLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    linkedList.addLast(node.right);
                }
            } else {
                isLeft = !isLeft;
                result.add(list);
                list = new LinkedList<>();
                if (linkedList.size() > 0) {
                    linkedList.addLast(null);
                }
            }
        }

        return result;
    }
}
