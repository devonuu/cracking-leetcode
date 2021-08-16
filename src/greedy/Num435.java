package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-16
 * Time : 오후 8:57
 * Title : Non-overlapping Intervals
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */


public class Num435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            // 끝나는 시간을 중심으로 가장 먼저 끝나는 순서로 정렬한다.
            // 왜냐하면 일찍 끝날 수록 남은 시간이 많아지고,
            // 그로 인해 선택할 수 있는 폭이 넓어지기 때문이다.
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });

        int[] select = intervals[0]; //최초의 경우는 선택한다. 가장 일찍 끝나기 때문이다.
        int nonOverlapCount = 1; // 안겹치고 최대한으로 많이 나열할 수 있는 수
        for (int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            if (start >= select[1]){ // 만약 다음 일정의 시작이 현재 일정의 종료 시점과 같거나 크다면 이것은 안겹치는 것임.
                nonOverlapCount++; //안겹치는 숫자 올려주고
                select = intervals[i]; //이녀석 다음부터 또 겹치는 친구들을 찾아야 하기 때문에 바꿔준다.
            }
        }
        return intervals.length - nonOverlapCount;
    }
}
