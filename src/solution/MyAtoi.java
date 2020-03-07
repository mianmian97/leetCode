package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-03 12:50
 */
public class MyAtoi {

    public static void main(String[] args) {

        System.out.println(myAtoi(" "));
    }

    public static int myAtoi(String str) {

        int index = 0;
        str = str.trim();

        if ("".equals(str)) {
            return 0;
        }

        int k = 1;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            k = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        int num = 0;
        while (index < str.length() && str.charAt(index) > 47 && str.charAt(index) < 58) {
            int pop = (str.charAt(index) - '0') * k;
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && pop > 7) {
                return Integer.MAX_VALUE;
            }
            if (num < Integer.MIN_VALUE / 10 || num == Integer.MIN_VALUE / 10 && pop < -8) {
                return Integer.MIN_VALUE;
            }
            num = num * 10 + pop;
            index++;
        }

        return num;
    }

}
