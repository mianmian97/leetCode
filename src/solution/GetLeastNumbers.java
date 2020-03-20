package solution;

import java.util.Arrays;

/**
 * @Author : zhangyi
 * @Date : 2020-03-20 16:52
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class GetLeastNumbers {

    public static void main(String[] args){

    }

    public static int[] getLeastNumbers(int[] arr, int k) {

        int[] ret = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
