package solution2.sort_search;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 插值查找
 */
public class InsertionSearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 6}, 6, 0, 4));
    }

    public static int search(int[] array, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        /**
         *    mid=(low+high)/2, 即mid=low+1/2*(high-low);
         * 　　通过类比，我们可以将查找的点改进为如下：
         * 　　mid=low+(key-a[low])/(a[high]-a[low])*(high-low)，
         * 　　也就是将上述的比例参数1/2改进为自适应的，根据关键字在整个有序表中所处的位置，让mid值的变化更靠近关键字key，这样也就间接地减少了比较次数。
         */
        int mid = left + (key - array[left]) / (array[right] - array[left]) * (right - left);
        if (array[mid] == key) {
            return mid;
        }
        if (array[mid] > key) {
            return search(array, key, left, mid - 1);
        }
        return search(array, key, mid + 1, right);
    }
}
