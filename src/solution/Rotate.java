package solution;

import java.util.Arrays;

/**
 * @Author : zhangyi
 * @Date : 2020-04-07 17:05
 * <p>
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 */
public class Rotate {

    public static void main(String[] args) {

        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(ints);
        System.out.println(Arrays.deepToString(ints));
    }

    public static void rotate(int[][] matrix) {

        int length = matrix.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (i != j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = t;
            }
        }
    }
}
