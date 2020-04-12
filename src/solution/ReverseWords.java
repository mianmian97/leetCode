package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-10 14:59
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class ReverseWords {

    public static void main(String[] args) {

        System.out.println(reverseWords("    "));
    }

    public static String reverseWords(String s) {

        if (Objects.isNull(s) || "".equals(s)) {
            return "";
        }

        String[] words = s.split(" ");
        if (words.length == 0) {
            return "";
        }

        StringBuilder wordbuilder = new StringBuilder();
        for (int k = words.length - 1; k >= 0; k--) {

            if (!"".equals(words[k])) {
                wordbuilder.append(words[k]).append(" ");
            }
        }

        String str = wordbuilder.toString();

        return str.substring(0, str.length() - 1);

    }
}
