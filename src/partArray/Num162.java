package partArray;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-25
 * Time : 오전 10:21
 * Title : Find Peak Element
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num162 {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length <= 1) return 0;

        while (start < end){
            int mid = (start + end) / 2;
            int num = nums[mid];
            int nextNum = nums[mid + 1];
            if (num < nextNum) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
