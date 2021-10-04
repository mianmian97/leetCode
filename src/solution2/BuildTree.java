package solution2;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length, preorder, map);
    }

    private TreeNode dfs(int leftIndex, int rightIndex, int[] preorder, Map<Integer, Integer> map) {

        if (leftIndex == rightIndex) {
            return null;
        }
        TreeNode node = new TreeNode();
        Integer rootVal = preorder[preIndex];
        preIndex++;
        node.val = rootVal;
        node.left = dfs(leftIndex, map.get(rootVal), preorder, map);
        node.right = dfs(map.get(rootVal) + 1, rightIndex, preorder, map);
        return node;
    }
}
