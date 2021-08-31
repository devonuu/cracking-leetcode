package partStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-31
 * Time : 오후 8:00
 * Title : Min Stack
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num155 {

    private LinkedList<Integer> stk;
    private LinkedList<Integer> min;

    public Num155() {
        stk = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        int last;
        if (min.isEmpty()){
            last = Integer.MAX_VALUE;
        }else {
            last = min.getLast();
        }
        if (val <= last) min.addLast(val);
        else min.addLast(last);
        stk.addLast(val);
    }

    public void pop() {
        stk.removeLast();
        min.removeLast();
    }

    public int top() {
        return stk.getLast();
    }

    public int getMin() {
        return min.getLast();
    }
}
