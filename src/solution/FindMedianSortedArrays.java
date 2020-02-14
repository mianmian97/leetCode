package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-02-14 21:33
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //暴力合并
        /*int length1 = nums1.length;
        int length2 = nums2.length;

        int[] nums = new int[length1 + length2];
        if (length1 == 0) {
            nums = nums2;
        } else if (length2 == 0) {
            nums = nums1;
        } else {
            int i = 0, j = 0, index = 0;
            while (i < length1 && j < length2) {
                nums[index++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            }
            if (i < length1) {
                while (i < length1) {
                    nums[index++] = nums1[i++];
                }
            }
            if (j < length2) {
                while (j < length2) {
                    nums[index++] = nums2[j++];
                }
            }
        }

        if ((length1 + length2) % 2 == 0) {
            return (nums[((length1 + length2) / 2) - 1] + nums[((length1 + length2) / 2)]) / 2.0;
        } else {
            return nums[(int) Math.floor((length1 + length2) / 2)];
        }*/

        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;

        int left = -1, right = -1;
        int index1 = 0, index2 = 0;

        for (int i = 0; i <= length / 2; i++) {
            left = right;
            if (index1 < length1 && (index2 >= length2 || nums1[index1] < nums2[index2])) {
                right = nums1[index1++];
            } else {
                right = nums2[index2++];
            }
        }
        if (length % 2 == 0) {
            return (left + right) / 2.0;
        }
        return right;
    }
}
