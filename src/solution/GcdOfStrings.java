package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-12 19:11
 */
public class GcdOfStrings {

    public static void main(String[] args) {

        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }

    public static String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int length = gcd(str1.length(), str2.length());

        return str1.substring(0, length);

    }

    public static int gcd(int a, int b) {

        return b == 0 ? a : gcd(b, a % b);
    }
}
