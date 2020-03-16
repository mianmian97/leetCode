package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-16 19:17
 * <p>
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {

        System.out.println(maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
        ));
    }


    //dfs下沉岛屿
    public static int maxAreaOfIsland(int[][] grid) {

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    num = Math.max(num, dfs(i, j, grid));
                }
            }
        }

        return num;
    }

    public static int dfs(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[x].length - 1 || grid[x][y] == 0) return 0;
        int num = 1;
        grid[x][y] = 0;
        num += dfs(x + 1, y, grid);
        num += dfs(x - 1, y, grid);
        num += dfs(x, y + 1, grid);
        num += dfs(x, y - 1, grid);

        return num;
    }
}
