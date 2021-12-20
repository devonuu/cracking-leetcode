package partArray.easy;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-20
 * Time : 오후 9:35
 * Title : Remove Duplicates from Sorted Array
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[left] != nums[i]){
                nums[++left] = nums[i];
            }
        }
        return left + 1;
    }
}
