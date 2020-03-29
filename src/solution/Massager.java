package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-24 19:21
 * <p>
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 */
public class Massager {

    public static void main(String[] args) {

        System.out.println(massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

    public static int massage(int[] nums) {

        int pre = 0;
        int curr = 0;
        for (int num : nums) {
            int t = curr;
            curr = Math.max(pre + num, curr);
            pre = t;
        }

        return curr;
    }
}
