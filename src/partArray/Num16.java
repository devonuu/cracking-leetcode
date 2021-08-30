package partArray;

import java.util.Arrays;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-28
 * Time : 오전 10:46
 * Title : 3Sum Closest
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int mid = left + 1;
        int right = nums.length - 1;
        int answer = nums[left] + nums[mid] + nums[right];

        while (left < nums.length - 2){
            while (mid < right){
                int tmp = nums[left] + nums[mid] + nums[right];
                if (tmp == target){
                    return tmp;
                }else if (tmp > target){
                    right--;
                }else {
                    mid++;
                }
                if (Math.abs(answer - target) > Math.abs(tmp - target)){
                    answer = tmp;
                }
            }
            left++;
            mid = left + 1;
            right = nums.length - 1;
        }
        return answer;
    }
}
