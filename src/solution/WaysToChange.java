package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-04-25 22:12
 * <p>
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 */
public class WaysToChange {

    int[] money = new int[]{1, 5, 10, 25};

    public int waysToChange(int n) {

        int[] result = new int[n + 1];
        result[0] = 1;

        for (int m : money) {
            for (int i = m; i < result.length; i++) {
                result[i] = (result[i] + result[i - m]) % 1000000007;
            }
        }

        return result[n];
    }
}
