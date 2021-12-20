package partArray.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-20
 * Time : 오후 9:54
 * Title : search-insert-position
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        if(left > right){
            return left;
        }else{
            return 0;
        }
    }
    @Test
    void searchInsert(){
        Assertions.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        Assertions.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
        Assertions.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
        Assertions.assertEquals(0, searchInsert(new int[]{1,3}, 0));
    }
}
