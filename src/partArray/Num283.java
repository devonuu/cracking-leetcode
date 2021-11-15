package partArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-24
 * Time : 오전 9:08
 * Title : Move Zeros
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num283 {
    public void moveZeroes(int[] nums) {
        int zero_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[zero_index];
                nums[zero_index] = tmp;
                zero_index++;
            }
        }
    }

    @Test
    void 영이_아닌_숫자_옮기기(){
        int[] test1 = new int[]{0,1,0,3,12};
        moveZeroes(test1);
        Assertions.assertArrayEquals(test1, new int[]{1,3,12,0,0});

        test1 = new int[]{0};
        moveZeroes(test1);
        Assertions.assertArrayEquals(test1, new int[]{0});
    }
}
