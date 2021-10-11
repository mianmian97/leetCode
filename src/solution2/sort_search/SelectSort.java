package solution2.sort_search;

import java.util.Arrays;
import java.util.Objects;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 4, 8, 4, 5};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array) {

        if (Objects.isNull(array) || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int t = array[i];
                array[i] = array[min];
                array[min] = t;
            }
        }
    }
}
