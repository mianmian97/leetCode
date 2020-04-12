package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-12 16:25
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (Objects.isNull(root)) return result;

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.addLast(root);
        nodeList.addLast(null);

        LinkedList<Integer> valList = new LinkedList<>();
        boolean leftOrder = true;

        while (nodeList.size() > 0) {
            TreeNode currNode = nodeList.pollFirst();

            if (Objects.nonNull(currNode)) {
                if (leftOrder) {
                    valList.addLast(currNode.val);
                } else {
                    valList.addFirst(currNode.val);
                }

                if (Objects.nonNull(currNode.left)) {
                    nodeList.addLast(currNode.left);
                }
                if (Objects.nonNull(currNode.right)) {
                    nodeList.addLast(currNode.right);
                }
            } else {
                result.add(valList);
                valList = new LinkedList<>();
                leftOrder = !leftOrder;
                if (nodeList.size() > 0) {
                    nodeList.addLast(null);
                }
            }
        }

        return result;
    }
}
