package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-08 22:25
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        int index = 0;
        char pre;
        while (true) {
            if (index >= strs[0].length()) {
                break;
            }
            pre = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (!(index < strs[i].length() && strs[i].charAt(index) == pre)) break;
            }
            index++;
        }
        return index == 0 ? "" : strs[0].substring(0, index);

    }
}
