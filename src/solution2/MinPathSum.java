package solution2;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] minGrid = new int[m][n];
        minGrid[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            minGrid[i][0] = grid[i][0] + minGrid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            minGrid[0][i] = grid[0][i] + minGrid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minGrid[i][j] = grid[i][j] + Math.min(minGrid[i - 1][j], minGrid[i][j - 1]);
            }
        }
        return minGrid[m - 1][n - 1];
    }
}
