package partStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-31
 * Time : 오후 7:30
 * Title : Minimum Remove to Make Valid Parentheses
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num1249 {
    public String minRemoveToMakeValid(String s) {
        //빈 문자열, 소문자만 포함
        //AB 혹은 A
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) continue;
            if (c == '('){
                stack.push(i);
            }else if (stack.isEmpty()){
                list.add(i);
            }else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < list.size(); i++) {
            builder.setCharAt(list.get(i), ' ');
        }
        while (!stack.isEmpty()){
            builder.setCharAt(stack.pop(), ' ');
        }
        return builder.toString().replaceAll(" ", "");
    }

    @Test
    void 테스트(){
        Assertions.assertEquals("lee(t(c)o)de" , minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
