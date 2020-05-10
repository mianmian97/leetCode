package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-05-10 10:32
 */
public class Multiply {

    public static void main(String[] args) {

        System.out.println(multiply("234", "35"));
    }

    public static String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) return "0";

        int l1 = num1.length(), l2 = num2.length();
        String result = "";

        for (int i = l1 - 1; i >= 0; i--) {
            int carry = 0;

            StringBuilder str = new StringBuilder();
            for (int k = 0; k < l1 - i - 1; k++) {
                str.append("0");
            }

            int n1 = num1.charAt(i) - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int mul = (n1 * n2 + carry) % 10;
                carry = (n1 * n2 + carry) / 10;
                str.append(mul);
            }
            if(carry != 0) str.append(carry);

            result = add(result, str.reverse().toString());
        }

        return result;
    }

    static String add(String num1, String num2) {

        StringBuilder sumBulider = new StringBuilder();
        int l1 = num1.length(), l2 = num2.length();
        int carry = 0;

        for (int i = l1 - 1, j = l2 - 1; i >= 0 || j >= 0; i--, j--) {

            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;

            sumBulider.append(sum);
        }
        if(carry != 0) sumBulider.append(carry);

        return sumBulider.reverse().toString();
    }
}
