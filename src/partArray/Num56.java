package partArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-25
 * Time : 오전 10:41
 * Title : Merge Intervals
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[0] == t2[0]){
                    return t2[1] - t1[1];
                }
                return t1[0] - t2[0];
            }
        });

        list.add(intervals[0]);
        int right_max = intervals[0][1];
        int merge_index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= right_max){
                right_max = Math.max(right_max, interval[1]);
                list.get(merge_index)[1] = right_max;
            }else {
                list.add(interval);
                merge_index++;
                right_max = interval[1];
            }
        }
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
