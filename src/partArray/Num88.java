package partArray;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-24
 * Time : 오전 11:23
 * Title : Merge Sorted Array
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx_read_1 = m - 1;
        int idx_read_2 = n - 1;
        int idx_write_1 = nums1.length - 1;

        while (idx_read_2 >= 0 && idx_write_1 >= 0){
            if (idx_read_1 < 0){
                nums1[idx_write_1] = nums2[idx_read_2];
                idx_read_2--;
            }else if (nums1[idx_read_1] > nums2[idx_read_2]){
                nums1[idx_write_1] = nums1[idx_read_1];
                idx_read_1--;
            }else {
                nums1[idx_write_1] = nums2[idx_read_2];
                idx_read_2--;
            }
            idx_write_1--;
        }
    }

    @Test
    void 머지_솔트_테슷트(){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        Assertions.assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);

        nums1 = new int[]{4,5,6,0,0,0};
        nums2 = new int[]{1,2,3};
        merge(nums1, 3, nums2, 3);
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5,6}, nums1);

        nums1 = new int[]{1};
        nums2 = new int[]{};
        merge(nums1, 1, nums2, 0);
        Assertions.assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        Assertions.assertArrayEquals(new int[]{1}, nums1);

    }
}
