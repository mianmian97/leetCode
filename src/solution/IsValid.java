package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-03-23 15:47
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {

    public static void main(String[] args) {

        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {

        if (s.length() % 2 != 0) return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) stack.push(s.charAt(i));
            else {
                char popChar = stack.empty() ? '#' : stack.pop();
                if (Objects.isNull(map.get(popChar)) || s.charAt(i) != map.get(popChar)) return false;
            }
        }

        if (stack.empty()) return true;
        return false;
    }
}
