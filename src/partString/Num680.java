package partString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-18
 * Time : 오전 10:14
 * Title : valid palindrome 2
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num680 {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end){
            if (s.charAt(start) == s.charAt(end)){ //값이 같으면 바로바로 다음으로
                start++;
                end--;
                continue;
            }
            if (subValid(s.substring(start + 1, end + 1)) || subValid(s.substring(start, end))){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }

    static boolean subValid(String s){
        int start = 0;
        int end = s.length() - 1;
        while (start <= end){
            if (s.charAt(start) == s.charAt(end)){ //값이 같으면 바로바로 다음으로
                start++;
                end--;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    @Test
    void 회문_문자빼고_테스트(){
        //Assertions.assertEquals(false, validPalindrome("eeccccbebaeeabebccceea"));
        Assertions.assertEquals(true, validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
