package solution;

import java.util.Arrays;

/**
 * @Author : zhangyi
 * @Date : 2020-03-05 19:12
 */
public class DistributeCandies {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }

    public static int[] distributeCandies(int candies, int num_people) {


        int[] ret = new int[num_people];
        int i = 0;
        while (candies > 0) {

            ret[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i++;
        }
        return ret;
    }
}
