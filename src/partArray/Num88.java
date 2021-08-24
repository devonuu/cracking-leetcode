package partArray;
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
        //nums1.length = m + n
        //m -> nums1에 있는 0이 아닌 숫자의 개수
        int idx1 = m - 1;
        int idx2 = n - 1;
        int idxTotal = nums1.length - 1;

        while (idxTotal >= 0){
            if (idx2 < 0){
                nums1[idxTotal--] = nums1[idx1--];
            }else if (idx1 < 0){
                nums1[idxTotal--] = nums2[idx2--];
            }else if (nums1[idx1] > nums2[idx2]){
                nums1[idxTotal--] = nums1[idx1--];
            }else {
                nums1[idxTotal--] = nums2[idx2--];
            }
        }
    }
}
