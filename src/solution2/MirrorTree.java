package solution2;

import java.util.Objects;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {

        if(Objects.isNull(root)){
            return root;
        }
        TreeNode mirrorNode = new TreeNode(root.val);
        mirrorNode.left = mirrorTree(root.right);
        mirrorNode.right = mirrorTree(root.left);
        return mirrorNode;
    }


}
