package solution;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author : zhangyi
 * @Date : 2020-04-07 15:36
 */
public class SimplifyPath {

    public static void main(String[] args) {

        System.out.println(simplifyPath("/.."));
    }

    public static String simplifyPath(String path) {

        if (Objects.isNull(path) || path.length() == 0) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        int i = 1;

        while (i > 0 && i < path.length()) {
            while (i < path.length() && path.charAt(i - 1) == '/' && path.charAt(i) == '/') i++;

            int end = path.indexOf("/", i) == -1 ? path.length() : path.indexOf("/", i);
            String fileP = path.substring(i, end);
            if (!"".equals(fileP)) {
                if (".".equals(fileP)) {
                } else if ("..".equals(fileP)) {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(fileP);
                }
            }
            i = end + 1;
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder p = new StringBuilder();
        while (!stack.isEmpty()) {
            p.insert(0, "/" + stack.pop());
        }
        return p.toString();
    }
}
