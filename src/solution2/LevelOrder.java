package solution2;

import java.util.*;

public class LevelOrder {

    public int[] levelOrder(TreeNode root) {

        if(Objects.isNull(root)){
            return new int[0];
        }
        Queue<TreeNode> stack = new LinkedList<>();
        List<Integer> nodeList = new ArrayList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            nodeList.add(node.val);
            if (Objects.nonNull(node.left)) {
                stack.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                stack.add(node.right);
            }
        }
        int[] array = new int[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            array[i] = nodeList.get(i);
        }
        return array;
    }
}
