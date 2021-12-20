package partArray.easy;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-20
 * Time : 오후 9:44
 * Title : Remove Element
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}
