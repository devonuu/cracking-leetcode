package greedy;
/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-16
 * Time : 오후 7:09
 * Title : Minimum Deletion Cost to Avoid Repeating Letters
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */
public class Num1578 {
    public int minCost(String s, int[] cost) {
        // cost[i]는 문자열 s에서 i번째 문자를 지울때 드는 비용이다.
        // 두 개의 동일한 문자가 나열되지 않도록 문자를 지우는 최소비용을 리턴하라.
        char c = s.charAt(0);
        int max_cost = cost[0];
        int sum = 0;
        for (int i = 1; i < s.length(); i++){
            if (c == s.charAt(i)){
                if (max_cost < cost[i]){
                    sum += max_cost;
                    max_cost = cost[i];
                }else {
                    sum += cost[i];
                }
            }else {
                c = s.charAt(i);
                max_cost = cost[i];
            }
        }
        return sum;
    }
}
