package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-05-06 18:51
 * <p>
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * <p>
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 */
public class MincostTickets {

    public static void main(String[] args) {

        System.out.println(mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }

    public static int mincostTickets(int[] days, int[] costs) {

        int len = days.length, minDay = days[0], maxDay = days[len - 1];
        int[] db = new int[maxDay + 31];

        for (int i = len - 1, day = maxDay; day >= minDay; day--) {
            if (day == days[i]) {
                db[day] = Math.min(Math.min(db[day + 1] + costs[0], db[day + 7] + costs[1]), db[day + 30] + costs[2]);
                i--;
            } else {
                db[day] = db[day + 1];
            }
        }

        return db[minDay];
    }
}
