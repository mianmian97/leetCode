package solution2;

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {-5}
        };
        System.out.println(findNumberIn2DArray(matrix, -5));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int x = m - 1, y = 0;
        while (y < n && x >= 0) {
            if (matrix[y][x] > target) {
                x--;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}
