package solution2;

import java.util.*;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        boolean isLeft = true;
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        Deque<Integer> valQueue = new ArrayDeque<>();
        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.pop();
            if (Objects.nonNull(node)) {
                if (isLeft) {
                    valQueue.addLast(node.val);
                } else {
                    valQueue.addFirst(node.val);
                }

                if (Objects.nonNull(node.left)) {
                    nodeQueue.addLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    nodeQueue.addLast(node.right);
                }
            } else {
                isLeft = !isLeft;
                nodeQueue.addLast(null);
                if (!nodeQueue.isEmpty()) {
                    result.add(new ArrayList<>(valQueue));
                }
                valQueue = new ArrayDeque<>();
            }
        }
        return result;

    }


}
