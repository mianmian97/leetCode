package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-19 17:27
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    public static void main(String[] args) {

        System.out.println(letterCombinations("2378"));
    }

    private static List<String> ret;
    private static String[] strArr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {

        ret = new ArrayList<>();
        if(Objects.isNull(digits)||"".equals(digits)){
            return ret;
        }

        findCombinations(digits, 0, "");
        return ret;
    }

    private static void findCombinations(String digits, int index, String c) {
        if (index == digits.length()) {
            ret.add(c);
            return;
        }

        char number = digits.charAt(index);
        String str = strArr[number - '0'];

        for (int i = 0; i < str.length(); i++) {
            findCombinations(digits, index + 1, c + str.charAt(i));
        }
    }


}
