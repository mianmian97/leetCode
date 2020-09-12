/**
 * @(#)AddStrings.java, 8月 03, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package solution;

/**
 * @Author: Zhang Yi
 * @Date: 2020/8/3 9:25 上午
 */
public class AddStrings {

    public static void main(String[] args) {

        System.out.println(addStrings("999", "10000"));

    }

    public static String addStrings(String num1, String num2) {

        int length1 = num1.length(), length2 = num2.length();
        int k = 0;
        StringBuilder str = new StringBuilder();

        for (int i1 = length1 - 1, i2 = length2 - 1; i1 >= 0 || i2 >= 0; i1--, i2--) {
            int n1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int n2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;

            str.insert(0, (n1 + n2 + k) % 10);
            k = (n1 + n2 + k) / 10;
        }
        if (k != 0) {
            str.insert(0, k);
        }
        return str.toString();
    }
}