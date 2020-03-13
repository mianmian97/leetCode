package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-13 18:51
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {

        //map存储
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (Objects.nonNull(map.get(num))) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        return 0;*/

        //排序取中间数
        /*Arrays.sort(nums);
        return nums[nums.length / 2];*/

        //投票法
        int mag = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == mag) {
                count++;
            } else {
                if (count == 0) {
                    mag = nums[i];
                    count = 1;
                }
                count--;
            }
        }
        return mag;
    }
}
