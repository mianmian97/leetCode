package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-03 12:50
 */
public class MyAtoi {

    public static void main(String[] args) {

        System.out.println(myAtoi("-2147483648"));
    }

    public static int myAtoi(String str) {

        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }

        int k = 1;
        int index = 0;
        int num = 0;

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            k = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {

            if (k == 1 && (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && (str.charAt(index) - '0' > 7)))) {
                num = Integer.MAX_VALUE;
                break;
            }
            if (k == -1 && (-num < (Integer.MIN_VALUE) / 10 || (-num == Integer.MIN_VALUE / 10 && (str.charAt(index) - '0' > 8)))) {
                num = Integer.MIN_VALUE;
                break;
            }
            num = num * 10 + (str.charAt(index) - '0');
            index++;
        }

        return num * k;
    }

}
