package partArray;
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
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[zeroIndex];
                nums[zeroIndex] = nums[i];
                nums[i] = tmp;
                zeroIndex++;
            }
        }
    }
}
