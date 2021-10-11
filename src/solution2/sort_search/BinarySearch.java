package solution2.sort_search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 6}, 2, 0, 4));
    }

    public static int search(int[] array, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right + 1) / 2;
        if (array[mid] == key) {
            return mid;
        }
        if (array[mid] > key) {
            return search(array, key, left, mid -1 );
        }
        return search(array, key, mid + 1, right);
    }
}
