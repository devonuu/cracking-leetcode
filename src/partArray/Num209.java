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

        int start = 0;
        int end = 0;
        while (end < nums.length){
            sum += nums[end++];
            while (sum >= target){
                min = Math.min(min, end - start);
                sum -= nums[start++];
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
