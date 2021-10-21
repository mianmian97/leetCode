package solution2;

import java.util.Objects;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return (Objects.nonNull(A) && Objects.nonNull(B)) && (dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean dfs(TreeNode nodeA, TreeNode nodeB) {

        if (Objects.isNull(nodeB)) {
            return true;
        }
        if (Objects.isNull(nodeA) || nodeA.val != nodeB.val) {
            return false;
        }
        return dfs(nodeA.left, nodeB.left) && dfs(nodeA.right, nodeB.right);
    }
}
