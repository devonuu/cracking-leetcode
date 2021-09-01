package partStack;

import java.util.Stack;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-09-01
 * Time : 오후 4:56
 * Title : Basic Calculator II
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num227 {
    public int calculate(String s) {

        Stack<Integer> stk = new Stack<>();
        int num = 0;
        char oper = ' ';
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (Character.isDigit(charAt)) {
                num = (num * 10) + (charAt - '0');
            }else if (charAt == ' ') {
                continue;
            }else {
                calculate(stk, num, oper);
                oper = charAt;
                num = 0;
            }
        }
        if (num > 0){
            calculate(stk, num, oper);
        }
        int sum = 0;
        while (!stk.isEmpty()){
            sum += stk.pop();
        }
        return sum;
    }

    private void calculate(Stack<Integer> stk, int num, char oper) {
        if (oper == '-') {
            stk.push(num * -1);
        } else if (oper == '*') {
            Integer pop = stk.pop();
            pop *= num;
            stk.push(pop);
        } else if (oper == '/') {
            Integer pop = stk.pop();
            pop /= num;
            stk.push(pop);
        } else {
            stk.push(num);
        }
    }
}
