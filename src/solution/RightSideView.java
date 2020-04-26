package solution;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author : zhangyi
 * @Date : 2020-04-22 13:17
 */
public class RightSideView {

    public static void main(String[] args) {

        /*DecimalFormat FORMAT = new DecimalFormat("0.00");
        String rep = Strings.repeat("0", 2);
        System.out.println(rep);
        String format = rep.length() == 0 ? "0" : "0." + rep;
        System.out.println(format);
        String format1 = new DecimalFormat(format).format(6900 * 0.01d);
        System.out.println(format1);*/

        System.out.println(new DecimalFormat("0.##").format(69.00f));
        System.out.println(new DecimalFormat("#.##").format(69.01d));

        System.out.println(new DecimalFormat("#.##").format(69.033));
        System.out.println(new DecimalFormat("#.#").format(69.033));

        DecimalFormat df = new DecimalFormat("###.00");
        float f = 20.0f;
        System.out.println("你不想要的：" + f);
        System.out.println("你想要的答案：" + df.format(f));
    }

    public List<Integer> rightSideView(TreeNode root) {

        //深度优先搜索
        /*List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> heightMap = new HashMap<>();

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();

        nodeStack.push(root);
        heightStack.push(0);
        int maxHeight = -1;

        while (!nodeStack.isEmpty()) {

            TreeNode node = nodeStack.pop();
            Integer height = heightStack.pop();
            if (Objects.nonNull(node)) {

                maxHeight = Math.max(height, maxHeight);
                heightMap.putIfAbsent(height, node.val);

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                heightStack.push(height + 1);
                heightStack.push(height + 1);
            }
        }

        for (int h = 0; h <= maxHeight; h++) {
            list.add(heightMap.get(h));
        }

        return list;*/

        //广度优先搜索
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> heightMap = new HashMap<>();

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> heightQueue = new LinkedList<Integer>();

        nodeQueue.add(root);
        heightQueue.add(0);
        int maxHeight = -1;

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.remove();
            Integer height = heightQueue.remove();
            if (Objects.nonNull(node)) {

                maxHeight = Math.max(height, maxHeight);
                heightMap.putIfAbsent(height, node.val);

                nodeQueue.add(node.right);
                nodeQueue.add(node.left);
                heightQueue.add(height + 1);
                heightQueue.add(height + 1);
            }
        }

        for (int h = 0; h <= maxHeight; h++) {
            list.add(heightMap.get(h));
        }

        return list;
    }

}
