package partStack;

import java.util.Stack;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-31
 * Time : 오후 7:15
 * Title : Valid Parentheses
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '(' || charAt == '[' || charAt == '{'){
                stack.push(charAt);
            }else if (stack.isEmpty()){
                return false;
            }else if ((charAt == ')' && stack.peek() == '(')
                || (charAt == ']' && stack.peek() == '[')
                || (charAt == '}' && stack.peek() == '{')
            ){
                stack.pop();
            }else {
                return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
