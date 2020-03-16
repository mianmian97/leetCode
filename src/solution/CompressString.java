package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-16 18:45
 * <p>
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）
 */
public class CompressString {

    public static void main(String[] args) {

        System.out.println(compressString("abbccd"));
    }

    public static String compressString(String S) {

        if (Objects.isNull(S) || "".equals(S)) {
            return "";
        }

        int n = 1;
        StringBuilder builder = new StringBuilder();
        builder.append(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                n++;
            } else {
                builder.append(n);
                builder.append(S.charAt(i));
                n = 1;
            }
        }
        builder.append(n);

        if (builder.toString().length() >= S.length()) return S;
        return builder.toString();

    }
}
