package partArray.easy;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-21
 * Time : 오후 8:50
 * Title : maximum-subarray
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }
}
