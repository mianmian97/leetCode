package solution;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-04-01 20:35
 * <p>
 * 有效括号的嵌套深度
 */
public class MaxDepthAfterSplit {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxDepthAfterSplit("(()((())))")));
    }

    public static int[] maxDepthAfterSplit(String seq) {

        /*int[] arr = new int[seq.length()];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                stack.push(seq.charAt(i));
                arr[i] = stack.size() & 1;
            } else {
                stack.pop();
                arr[i] = stack.size() + 1 & 1;
            }
        }
        return arr;*/

        int[] arr = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                arr[i] = i & 1;
            } else {
                arr[i] = i + 1 & 1;
            }
        }
        return arr;
    }
}
