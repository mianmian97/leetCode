package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-01 11:51
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        String s = "ababacc";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if (Objects.isNull(s) || "".equals(s)) {
            return "";
        }

        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            int length1 = expandAroundCenter(s, i, i);
            int length2 = expandAroundCenter(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > endIndex - startIndex) {
                startIndex = i - ((length - 1) / 2);
                endIndex = i + (length / 2);
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    private static int expandAroundCenter(String str, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
