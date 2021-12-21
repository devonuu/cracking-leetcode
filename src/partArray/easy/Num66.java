package partArray.easy;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-21
 * Time : 오후 9:16
 * Title : Plus One
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num66 {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] == 10){
                digits[i] = 0;
            }else{
                return digits;
            }
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
        }
        return res;
    }
}
