package partArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-24
 * Time : 오전 10:36
 * Title : Sort Colors
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num75 {
    public void sortColors(int[] nums) {
        int idx0 = 0;
        int idx1 = 0;
        int idx2 = nums.length - 1;
        while (idx1 <= idx2){
            if (nums[idx1] == 0){
                swap(nums, idx1, idx0);
                idx0++;
                idx1++;
            }else if (nums[idx1] == 2){
                swap(nums, idx1, idx2);
                idx2--;
            }else{
                idx1++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    @Test
    void 테슽(){
        int[] nums = new int[]{2,0,1};
        sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0,1,2}, nums);

        nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0,0,1,1,2,2}, nums);
    }
}
