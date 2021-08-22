package partString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-18
 * Time : 오전 10:13
 * Title : Valid Palindrome
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num125 {
    public boolean isPalindrome(String s) {
        //양쪽 끝을 비교하면서 투 포인터를 움직여준다.
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start <= end){
            if (!rangeCheck(s.charAt(start))){
                start++;
                continue;
            }
            if (!rangeCheck(s.charAt(end))){
                end--;
                continue;
            }
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

    static boolean rangeCheck(char c){
        if (c >= 48 && c <= 57) return true;
        if (c >= 65 && c <= 90) return true;
        if (c >= 97 && c <= 122) return true;
        return false;
    }

    @Test
    void palindrome(){
        Assertions.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
    }
}
