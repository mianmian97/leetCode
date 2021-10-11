package solution2.sort_search;

import java.util.Arrays;
import java.util.Objects;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3, 7, 8, 4};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
    }
}
