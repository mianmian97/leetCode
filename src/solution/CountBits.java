package solution;

import java.util.Arrays;

/**
 * @Author : zhangyi
 * @Date : 2020-05-07 21:00
 */
public class CountBits {

    public static void main(String[] args){

        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int num) {

        int[] result = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num) {
            while (i < b && i + b <= num) {
                result[i + b] = result[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }

        return result;
    }
}
