package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-04 13:04
 */
public class IsPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(111));
    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        //转字符串
        /*String numStr = String.valueOf(x);
        boolean isPalindrome = true;
        for (int i = 0, j = numStr.length() - 1; i <= j; i++, j--) {
            if (numStr.charAt(i) != numStr.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;*/

        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return rev == x || rev / 10 == x;
    }
}
