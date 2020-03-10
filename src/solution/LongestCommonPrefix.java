package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-08 22:25
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }

        String str1;
        String str2 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str1 = strs[i];
            str2 = getPre(str1, str2);
        }

        return str2;
    }

    private static String getPre(String str1, String str2) {

        int endIndex = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) != (str2.charAt(i))) {
                break;
            }
            endIndex++;
        }

        return str1.substring(0, endIndex);
    }
}
