package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-05-09 20:04
 */
public class MySqrt {

    public static void main(String[] args) {

        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {

        int start = 0, end = x;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return ans;

        /*int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;*/
    }
}
