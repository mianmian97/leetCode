package solution;

import com.sun.tools.javac.util.StringUtils;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-05-08 18:56
 * <p>
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaximalSquare {

    public static void main(String[] args) {

        char[][] arr = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},

        };
        System.out.println(maximalSquare(arr));
    }

    public static int maximalSquare(char[][] matrix) {

        if (Objects.isNull(matrix) || matrix.length == 0) return 0;

        int maxLength = 0;
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = Math.min(result[i - 1][j - 1], Math.min(result[i][j - 1], result[i - 1][j])) + 1;
                    }
                    maxLength = Math.max(maxLength, result[i][j]);
                }
            }
        }

        return maxLength * maxLength;
    }
}
