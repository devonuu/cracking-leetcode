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
        int left = 0; //0 관리
        int mid = 0;
        int right = nums.length - 1; //2 관리함

        while (mid <= right){
            //값이 2일 경우 바꾸기만함.
            //값이 0일 경우 바꾸기만.
            //값이 1일 경우 이동.
            if (nums[mid] == 2){
                swap(nums, right, mid);
                right--;
            }else if (nums[mid] == 0){
                swap(nums, left, mid);
                left++;
                mid++;
            }else {
                mid++;
            }
        }
    }

    static void swap(int[] nums, int a, int b){
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
