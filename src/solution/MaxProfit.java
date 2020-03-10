package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-09 18:18
 */
public class MaxProfit {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7, 9, 1, 6}));

    }

    public static int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        return max;
    }
}
