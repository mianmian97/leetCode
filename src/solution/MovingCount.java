package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-04-08 23:43
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class MovingCount {

    public static void main(String[] args) {

        System.out.println(movingCount(2, 3, 1));
    }

    public static int movingCount(int m, int n, int k) {

        if (m == 0 || n == 0) return 0;
        int[][] map = new int[m][n];
        return move(0, 0, map, k);

    }

    public static int move(int x, int y, int[][] map, int k) {

        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == 1) return 0;
        int count = 0;
        int x1 = x;
        while (x1 > 0) {
            count += x1 % 10;
            x1 /= 10;
        }
        if (count > k) return 0;
        int y1 = y;
        while (y1 > 0) {
            count += y1 % 10;
            y1 /= 10;
        }
        if (count > k) return 0;

        int num = 1;
        map[x][y] = 1;
        num += move(x + 1, y, map, k);
        num += move(x - 1, y, map, k);
        num += move(x, y + 1, map, k);
        num += move(x, y - 1, map, k);

        return num;

    }
}
