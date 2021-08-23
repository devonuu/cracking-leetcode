package partString;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-23
 * Time : 오전 11:23
 * Title : Longest Substring Without Repeating Characters
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.trim().isEmpty()) return 0;

        int start = 0;
        int end = 0;
        int max = 0;
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        while (end < s.length()){
            int index = s.charAt(end) - 'a';
            if (alpha[index] > -1){ //이미 나온적있음
                if (alpha[index] >= start && alpha[index] <= end){ //근데 현재 블록안에 있음.
                    start++;
                    max = Math.max(max, end - start + 1);
                    start = alpha[index] + 1;
                    alpha[index] = end;
                }
            }else{
                alpha[index] = end;
            }
            end++;
        }
        return max;
    }

    @Test
    void 테스트(){
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
