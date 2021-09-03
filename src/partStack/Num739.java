package partStack;

import java.util.LinkedList;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-09-01
 * Time : 오후 6:05
 * Title : Daily Temperatures
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // [value, index]
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> idxStk = new Stack<>();

        LinkedList<Integer> list = new LinkedList<>();
        for (int index = temperatures.length - 1; index >= 0; index--) {
            int temperature = temperatures[index];
            int lastTempIdx = 0;
            while (!stk.isEmpty()){
                int peek = stk.peek();
                lastTempIdx = idxStk.peek();

                if (peek <= temperature){
                    stk.pop();
                    idxStk.pop();
                }else{
                    break;
                }
            }
            if (stk.isEmpty()){
                stk.push(temperature);
                idxStk.push(index);
                list.add(0);
            }

            stk.push(temperature);
            idxStk.push(index);
            list.add(lastTempIdx - index);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    @Test
    void 테스트(){
        Assertions.assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }
}
