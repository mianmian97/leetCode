package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author : zhangyi
 * @Date : 2020-03-06 23:25
 */
public class FindContinuousSequence {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }

    public static int[][] findContinuousSequence(int target) {

        /**
         * 根据等差数列求和公式
         * target = n * a1 + n * (n - 1) * d / 2
         * d = 1
         * ---> a1 = (target - n * (n - 1) / 2) / n
         */
        List<int[]> arrayList = new ArrayList<>();

        int n = 2;
        while (true) {
            double first = (target - n * (n - 1) / 2.0) / n;
            if (0 >= first) {
                break;
            }
            if (Math.floor(first) == Math.ceil(first)) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = (int) (first + i);
                }
                arrayList.add(arr);
            }
            n++;
        }

        Collections.reverse(arrayList);
        return arrayList.toArray(new int[arrayList.size()][]);
    }
}
