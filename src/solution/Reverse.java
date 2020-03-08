package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-07 23:30
 */
public class Reverse {

    public static void main(String[] args) {

        System.out.println(reverse(120));
    }

    public static int reverse(int x) {

        int rev = 0, k = 1;
        if (x < 0) {
            k = -1;
            x *= k;
        }
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < rev || Integer.MAX_VALUE / 10 == rev && x % 10 > 7) {
                return 0;
            }
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev * k;
    }
}
