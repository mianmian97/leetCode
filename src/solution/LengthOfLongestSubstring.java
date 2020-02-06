package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : zhangyi
 * @Date : 2020-02-06 20:46
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        //暴力法
        /*if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }

        int startIndex = 0;
        int endIndex = 1;
        int maxLength = 0;
        int length = 1;

        while (endIndex < s.length()) {
            String substring = s.substring(startIndex, endIndex);
            String nextChat = s.substring(endIndex, endIndex + 1);

            if (!substring.contains(nextChat)) {
                length++;
                endIndex++;
            } else {
                length = 1;
                startIndex++;
                endIndex = startIndex + 1;
            }
            maxLength = Integer.max(maxLength, length);
        }*/


        //滑动窗口
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return maxLength;
    }
}
