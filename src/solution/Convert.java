package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-02 00:36
 */
public class Convert {

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s, 4));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int cyc = 2 * numRows - 2;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j + i < s.length(); j += cyc) {
                str.append(s.charAt(j + i));

                if (i != 0 && i != numRows - 1 && j + cyc - i < s.length()) {
                    str.append(s.charAt(j + cyc - i));
                }

            }

        }
        return str.toString();
    }
}
