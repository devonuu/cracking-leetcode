package partString;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-18
 * Time : 오전 9:53
 * Title : Rotate String
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
