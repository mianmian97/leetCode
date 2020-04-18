package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-14 16:17
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 */
public class NumIslands {

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '1' }
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int count = 0;
        if (Objects.isNull(grid) || grid.length == 0) {
            return count;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, char[][] grid) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;

        if (grid[x][y] == '0') return;

        grid[x][y] = '0';
        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
    }
}
