package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-19 15:35
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class longestPalindromeLength {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {

        /*Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (Objects.nonNull(map.get(s.charAt(i)))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else
                map.put(s.charAt(i), 1);
        }

        boolean hassiginal = false;
        int length = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                length += entry.getValue();
            } else {
                hassiginal = true;
                length += entry.getValue() - 1;
            }
        }
        if (hassiginal) length += 1;
        return length;*/

        int n = 0;
        int[] charArr = new int[128];
        for (char c : s.toCharArray()) {
            charArr[c]++;
        }
        for (Integer count : charArr) {
            n += count % 2;
        }
        return n == 0 ? s.length() : s.length() - n + 1;

    }
}
