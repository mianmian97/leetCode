package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-21 20:29
 */
public class PathSum {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(Objects.isNull(root)) return lists;

        back(root, sum, 0, new ArrayList());
        return lists;
    }

    public void back(TreeNode node, int sum, int curSum, List l) {

        l.add(node.val);
        curSum += node.val;

        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            if (curSum == sum) {
                lists.add(new ArrayList<>(l));
            }
            l.remove(l.size() - 1);
            return;
        }

        if(Objects.nonNull(node.left)) {
            back(node.left, sum, curSum, l);
        }
        if(Objects.nonNull(node.right)) {
            back(node.right, sum, curSum, l);
        }

        l.remove(l.size() - 1);
    }
}
