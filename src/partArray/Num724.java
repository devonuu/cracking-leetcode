package partArray;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-24
 * Time : 오전 9:27
 * Title : Find Pivot Index
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num724 {
    public int pivotIndex(int[] nums) {
        int left_sum = 0;
        int right_sum = Arrays.stream(nums).sum();
        int pivot = 0;

        for (int i = 0; i < nums.length; i++) {
            right_sum -= nums[i];
            left_sum += pivot;
            pivot = nums[i];
            if (left_sum == right_sum) return i;
        }
       ;
        return -1;
    }

    @Test
    void sliding(){
        Assertions.assertEquals(pivotIndex(new int[]{1,7,3,6,5,6}), 3);
        Assertions.assertEquals(pivotIndex(new int[]{2,1,-1}), 0);
        Assertions.assertEquals(pivotIndex(new int[]{1,2,3}), -1);
    }
}
