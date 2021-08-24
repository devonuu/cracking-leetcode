package partArray;
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
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
