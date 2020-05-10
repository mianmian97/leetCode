package solution;

import java.util.Objects;

/**
 * @Author : zhangyi
 * @Date : 2020-05-10 23:23
 */
public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {

        if(Objects.isNull(nums) || nums.length == 0) return 0;

        int l = 0;
        int maxLength = 0;

        while(l < nums.length){
            int r = l + 1;
            while(r < nums.length && nums[r] > nums[r - 1]) r++;
            maxLength = Math.max(maxLength, r - l);

            l = r;
        }

        return maxLength;
    }
}
