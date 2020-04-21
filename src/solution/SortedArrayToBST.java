package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-04-21 14:10
 */
public class SortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(0, nums.length - 1, nums);

    }

    private TreeNode helper(int left, int right, int[] nums) {

        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(left, mid - 1, nums);
        root.right = helper(mid + 1, right, nums);
        return root;
    }


}
