package partString;
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
        int start = 0;
        int end = s.length() - 1;
        while (start <= end){
            if (s.charAt(start) == s.charAt(end)){
                if (rangeCheck(s.charAt(start))){
                    start++;
                    end++;
                }
            }
        }
    }

    static boolean rangeCheck(char c){
        if (c >= 48 && c <= 57) return true;
        if (c >= 65 && c <= 90) return true;
        if (c >= 97 && c <= 122) return true;
        return false;
    }
}
