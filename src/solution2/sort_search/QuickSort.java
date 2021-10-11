package solution2.sort_search;

import java.util.Arrays;
import java.util.Objects;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3, 7, 8, 4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = partition(array, left, right);
        sort(array, left, key - 1);
        sort(array, key + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= pivotKey)
                right--;
            arr[left] = arr[right]; //把小的移动到左边
            while (left < right && arr[left] <= pivotKey)
                left++;
            arr[right] = arr[left]; //把大的移动到右边
        }
        arr[left] = pivotKey; //最后把pivot赋值到中间
        return left;
    }

}
