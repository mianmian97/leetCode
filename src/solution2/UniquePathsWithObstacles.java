package solution2;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0, 0},
                {1, 1},
                {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            path[i][0] = (obstacleGrid[i][0] == 1 || (i > 0 && path[i - 1][0] == 0)) ? 0 : 1;
        }
        for (int i = 0; i < n; i++) {
            path[0][i] = (obstacleGrid[0][i] == 1 || (i > 0 && path[0][i - 1] == 0)) ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = obstacleGrid[i][j] == 1 ? 0 : path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }
}
