package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhangyi
 * @Date : 2020-04-18 21:47
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */
public class BuildTree2 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int[] inorder;
    private int[] postorder;

    private Integer posterIndex;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;
        this.postorder = postorder;
        posterIndex = postorder.length - 1;

        int i = 0;
        for (int num : inorder) map.put(num, i++);

        return help(0, postorder.length - 1);
    }

    private TreeNode help(int left, int right) {

        if (left > right) return null;

        int rootVal = postorder[posterIndex];
        posterIndex--;

        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = help(left, map.get(rootVal) - 1);
        rootNode.right = help(map.get(rootVal) + 1, right);

        return rootNode;

    }
}


class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right)
            return null;

        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        post_idx--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postorder = postorder;
        this.inorder = inorder;
        post_idx = postorder.length - 1;

        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length - 1);
    }

}
