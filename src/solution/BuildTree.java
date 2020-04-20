package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhangyi
 * @Date : 2020-04-18 21:22
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class BuildTree {

    private Map<Integer, Integer> map = new HashMap<>();

    private int preIndex = 0;

    private int[] preorder;

    private int[] inorder;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;
        this.inorder = inorder;

        int i = 0;
        for (int num : inorder) map.put(num, i++);

        return help(0, map.size());
    }

    private TreeNode help(int left, int right) {

        if (left == right) return null;

        int rootVal = preorder[preIndex];
        TreeNode rootNode = new TreeNode(rootVal);

        preIndex++;
        rootNode.left = help(left, map.get(rootVal));
        rootNode.right = help(map.get(rootVal) + 1, right);

        return rootNode;
    }
}













