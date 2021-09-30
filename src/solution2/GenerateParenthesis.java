package solution2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        dfs(list, "", n, n);
        return list;
    }

    public static void dfs(List<String> list, String s, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(s);
        }

        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(list, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(list, s + ")", left, right - 1);
        }
    }
}
