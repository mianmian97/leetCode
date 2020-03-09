package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-08 21:38
 */
public class IntToRoman {

    public static void main(String[] args) {

        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int n = 0;

        StringBuilder str = new StringBuilder();
        while (n < nums.length) {
            while (num >= nums[n]) {
                str.append(roman[n]);
                num -= nums[n];
            }
            n++;
        }
        return str.toString();
    }
}
