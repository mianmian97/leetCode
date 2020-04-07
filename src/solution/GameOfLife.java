package solution;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-04-02 15:36
 */
public class GameOfLife {

    public static void main(String[] args) {

        gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }

    public static void gameOfLife(int[][] board) {

        if (Objects.isNull(board) || board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                liveOrDie(i, j, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
        System.out.println(Arrays.deepToString(board));

    }

    private static void liveOrDie(int x, int y, int[][] board) {

        int[][] arr = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        int liveCount = 0;
        for (int[] point : arr) {
            if (x + point[0] < 0 || x + point[0] >= board.length || y + point[1] < 0 || y + point[1] >= board[0].length)
                continue;
            liveCount += (board[x + point[0]][y + point[1]] % 2);
        }

        /**
         * 下一轮状态，当前状态
         *      0       0   -》0
         *      0       1   -》1
         *      1       0   -》2
         *      1       1   -》3
         */
        if (board[x][y] == 1) {
            if (liveCount < 2 || liveCount > 3) board[x][y] = 1;
            else board[x][y] = 3;
        } else if (liveCount == 3) board[x][y] = 2;
    }

}
