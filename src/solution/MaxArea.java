package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-07 23:52
 */
public class MaxArea {

    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {

        //暴力法
        /*int max = 0;
        for (int n = 1; n < height.length; n++) {
            int startIndex = 0;
            while (startIndex + n < height.length) {
                max = Math.max(max, Math.min(height[startIndex], height[startIndex + n]) * n);
                startIndex++;
            }
        }
        return max;*/

        //双指针法
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            max = Math.max(max,( end - start) * Math.min(height[start], height[end]));
            if (height[start] > height[end]) end--;
            else start++;
        }
        return max;
    }
}
