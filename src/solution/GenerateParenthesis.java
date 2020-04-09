package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : zhangyi
 * @Date : 2020-03-28 22:16
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        dfs("", n, n, list);

        if (n == 0) {
            return list;
        }

        return list;

    }

    private static void dfs(String str, int left, int right, List<String> list) {

        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }

        if (left > right) return;

        if (left > 0) {
            dfs(str + "(", left - 1, right, list);
        }

        if (right > 0) {
            dfs(str + ")", left, right - 1, list);
        }
    }


}
