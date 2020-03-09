package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-08 20:28
 */
public class CoinChange {

    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{2}, 3));
    }

    private static int res = Integer.MAX_VALUE;

    public static int coinChange(int[] coins, int amount) {

        if (coins.length == 0) {
            return -1;
        }
        find(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    static void find(int[] coins, int amount, int n) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, n);
        }
        for (int i = 0; i < coins.length; i++) {
            find(coins, amount - coins[i], n+1);
        }
    }
}
