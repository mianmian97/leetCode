package solution2;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {

        if(n < 3){
            return n;
        }
        int[] step = new int[n + 1];
        step[0] = 0;
        step[1] = 1;
        step[2] = 2;
        for (int i = 3; i < step.length; i++) {
            step[i] = step[i - 1] + step[i - 2] ;
        }
        return step[n];
    }
}
