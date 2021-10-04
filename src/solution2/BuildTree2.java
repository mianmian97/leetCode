package solution2;

import java.util.HashMap;
import java.util.Map;

public class BuildTree2 {

    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length, postorder, map);
    }

    private TreeNode dfs(int leftIndex, int rightIndex, int[] preorder, Map<Integer, Integer> map) {

        if (leftIndex == rightIndex) {
            return null;
        }
        TreeNode node = new TreeNode();
        Integer rootVal = preorder[postIndex];
        postIndex--;
        node.val = rootVal;
        node.right = dfs(map.get(rootVal) + 1, rightIndex, preorder, map);
        node.left = dfs(leftIndex, map.get(rootVal), preorder, map);
        return node;
    }
}
