package solution2.sort_search;

import java.util.Arrays;
import java.util.Objects;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int target = array[j];
            while (j > 0 && array[j - 1] > array[j]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
        }
    }

    public static void sort(int[] array){

        if(Objects.isNull(array) || array.length == 0){
            return;
        }
        for(int i = 1; i< array.length; i++){
            int j = i;
            int target = array[j];
            while(j > 0 && array[j - 1] > array[j]){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
        }
    }
}
