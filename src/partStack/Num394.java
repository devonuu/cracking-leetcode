package partStack;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-09-01
 * Time : 오후 3:00
 * Title : Decode String
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num394 {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();

        StringBuilder str = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '['){
                stringStack.push(str.toString());
                integerStack.push(count);

                str = new StringBuilder();
                count = 0;
            }else if (charAt == ']'){
                int num = integerStack.pop();
                StringBuilder builder = new StringBuilder(stringStack.pop());
                for (int j = 0; j < num; j++) {
                    builder.append(str);
                }
                str = builder;
            }else if (Character.isDigit(charAt)){
                count = (count * 10) + (charAt - '0');
            }else {
                str.append(charAt);
            }
        }
        return str.toString();
    }

    @Test
    void 테스트(){
        Assertions.assertEquals("abccdcdcdxyz", decodeString("abc3[cd]xyz"));
        Assertions.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
        Assertions.assertEquals("accaccacc", decodeString("3[a2[c]]"));
        Assertions.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    }
}
