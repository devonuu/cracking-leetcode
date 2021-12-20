package partArray.easy;

import java.util.stream.IntStream;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-20
 * Time : 오후 9:25
 * Title : Concatenation of Array
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num1929 {
    public int[] getConcatenation(int[] nums) {
        //return IntStream.concat(IntStream.of(nums), IntStream.of(nums)).toArray();
        int[] ans = new int[nums.length * 2];
        int i;
        for (i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            ans[i++] = nums[j];
        }
        return ans;
    }
}
