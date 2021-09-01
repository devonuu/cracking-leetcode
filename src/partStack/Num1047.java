package partStack;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-09-01
 * Time : 오전 10:21
 * Title : Remove All Adjacent Duplicates In String
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (stk.isEmpty()) {
                stk.push(charAt);
            }
            else if (stk.peek() == charAt) {
                stk.pop();
            }else {
                stk.push(charAt);
            }
        }
        if (stk.size() == 0) return "";

        StringBuilder builder = new StringBuilder();
        while (!stk.isEmpty()){
            builder.append(stk.pop());
        }
        return builder.reverse().toString();
    }

    @Test
    void 테스트(){
        Assertions.assertEquals("ca", removeDuplicates("abbaca"));
    }
}
