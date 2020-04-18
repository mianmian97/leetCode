package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-16 10:45
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Merge {

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {1, 4}
        };
        System.out.println(Arrays.deepToString(merge(array)));
    }

    public static int[][] merge(int[][] intervals) {

        if (Objects.isNull(intervals) || intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

        int[][] resultArray = new int[intervals.length][];
        int index = -1;
        for (int[] interval : intervals) {

            if (index == -1 || resultArray[index][1] < interval[0]) {
                resultArray[++index] = interval;
            } else {
                resultArray[index][1] = Math.max(resultArray[index][1], interval[1]);
            }
        }

        return Arrays.copyOf(resultArray, index);
    }
}
