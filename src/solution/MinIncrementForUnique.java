package solution;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-03-22 22:06
 * <p>
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class MinIncrementForUnique {

    public static void main(String[] args) {

        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public static int minIncrementForUnique(int[] A) {

        /*int addCount = 0;
        if (Objects.isNull(A) || A.length == 0) {
            return addCount;
        }

        Arrays.sort(A);

        while (true) {

            boolean isUnique = true;
            for (int i = A.length - 1; i > 0; i--) {

                if (A[i] == A[i - 1]) {
                    A[i]++;
                    addCount++;
                    isUnique = false;
                }
            }
            if (isUnique) break;
        }

        return addCount;*/

        int addCount = 0, token = 0;
        if (Objects.isNull(A) || A.length == 0) {
            return addCount;
        }

        Arrays.sort(A);

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                token++;
                addCount -= A[i];
            } else {
                int give = Math.min(token, A[i] - A[i - 1] - 1);
                addCount += give * A[i - 1] + give * (give + 1) * 0.5;
                token -= give;
            }
        }

        addCount += token * A[A.length - 1] + token * (token + 1) * 0.5;
        return addCount;
    }
}