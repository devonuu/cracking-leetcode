package partArray;
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
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }

        int beforeNum = 0;
        for (int pivot = 0; pivot < nums.length; pivot++) {
            int num = nums[pivot];
            right -= num;
            left += beforeNum;
            if (left == right) return pivot;
            beforeNum = num;
        }
        return -1;
    }
}
