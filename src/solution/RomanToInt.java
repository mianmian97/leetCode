package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-08 21:58
 */
public class RomanToInt {

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        int sum = 0;
        int preNum = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;

        return sum;

        /*int num = 0;

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(roman[i], nums[i]);
        }

        int index = 0;
        while (index + 1 <= s.length()) {
            if (index + 2 <= s.length() && Objects.nonNull(map.get(s.substring(index, index + 2)))) {
                num += map.get(s.substring(index, index + 2));
                index += 2;
            } else {
                num += map.get(s.substring(index, index + 1));
                index++;
            }
        }
        return num;*/
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
