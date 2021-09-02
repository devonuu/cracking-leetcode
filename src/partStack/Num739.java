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
        Stack<int[]> stk = new Stack<>();

        int index = temperatures.length - 1;
        LinkedList<Integer> list = new LinkedList<>();
        while (index >= 0){
            if (stk.isEmpty()) {
                list.addFirst(0);
                stk.push(new int[]{temperatures[index], index});
            }
            else {
                boolean isHighest = true;
                while (!stk.isEmpty()){
                    int[] peek = stk.peek();
                    if (peek[0] > temperatures[index]){
                        list.addFirst(peek[1] - index);
                        stk.push(new int[]{temperatures[index], index});
                        isHighest = false;
                        break;
                    }else{
                        stk.pop();
                    }
                }
                if (isHighest){
                    list.addFirst(0);
                    stk.push(new int[]{temperatures[index], index});
                }
            }
            index--;
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
