package partArray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-24
 * Time : 오전 8:55
 * Title : Binary Search
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    @Test
    void 이분_탐색_테스트(){
        assertEquals(search(new int[]{-1,0,3,5,9,12}, 9), 4);
        assertEquals(search(new int[]{-1,0,3,5,9,12}, 2), -1);
    }
}
