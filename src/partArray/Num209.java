package partArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-24
 * Time : 오전 9:44
 * Title :
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }
        if (min == Integer.MAX_VALUE) return 0;
        else return min;
    }

    @Test
    void 테스트(){
        Assertions.assertEquals(2, minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
