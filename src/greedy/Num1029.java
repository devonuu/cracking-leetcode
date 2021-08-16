package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-16
 * Time : 오후 7:27
 * Title : Two City Scheduling
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num1029 {
    public int twoCitySchedCost(int[][] costs) {
        //[a도시로 이동비용, b도시로 이동비용]
        Arrays.sort(costs, new Comparator<int[]>(){
            // b도시 비용 - a도시 비용 이 가장 큰 순으로 정렬해서 내림차순으로 정렬한다.
            // 이렇게 정렬하면 a도시로 이동하는 경우가 더 비용이 많이 절감되는 순서로 정렬 되기 때문에
            // 앞에 n명은 a도시로, 뒤에 n명은 b도시로 보내서 이동 비용을 최소화 할 수 있다.
            @Override
            public int compare(int[] o1, int[] o2){
                return (o2[1] - o2[0]) - (o1[1] - o1[0]);
            }
        });
        int half = costs.length / 2;
        int sum = 0;
        for (int i = 0; i < half; i++){
            sum += costs[i][0];
        }
        for (int i = half; i < costs.length; i++){
            sum += costs[i][1];
        }
        return sum;
    }
}
