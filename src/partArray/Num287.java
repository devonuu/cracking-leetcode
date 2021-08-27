package partArray;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-27
 * Time : 오후 1:20
 * Title : Find the Duplicate Number
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num287 {
    public int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]]) return nums[i];
            else arr[nums[i]] = true;
        }
        return 0;
    }
}
