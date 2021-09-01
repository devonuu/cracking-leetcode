package partStack;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-09-01
 * Time : 오후 2:39
 * Title : Remove All Adjacent Duplicates in String II
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (!stack1.isEmpty() && stack1.peek() == charAt){
                Integer peek = stack2.pop();
                if (peek + 1 == k){
                    stack1.pop();
                }else {
                    stack2.push(peek + 1);
                }
            }else{
                stack1.push(charAt);
                stack2.push(1);
            }
        }
        StringBuilder builder = new StringBuilder();

        while (!stack1.isEmpty()){
            Character c = stack1.pop();
            Integer num = stack2.pop();
            for (int i = 0; i < num; i++) {
                builder.append(c);
            }
        }
        return builder.reverse().toString();
    }

    @Test
    void 테스트(){
        Assertions.assertEquals("aa", removeDuplicates("deeedbbcccbdaa",3));
    }
}
