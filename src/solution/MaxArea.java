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
        int startIndex = 0, endIndex = height.length - 1;
        while (startIndex < endIndex) {

            max = Math.max(max, (endIndex - startIndex) * Math.min(height[startIndex], height[endIndex]));
            if (height[startIndex] < height[endIndex]) startIndex++;
            else endIndex--;
        }
        return max;
    }
}
