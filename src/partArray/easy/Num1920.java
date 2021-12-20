package partArray.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-20
 * Time : 오후 9:17
 * Title : Build Array from Permutation
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num1920 {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    @Test
    void buildArrayTest(){
        Assertions.assertArrayEquals(new int[]{0,1,2,4,5,3}, buildArray(new int[]{0,2,1,5,3,4}));
    }
}
