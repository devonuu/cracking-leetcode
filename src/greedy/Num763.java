package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-16
 * Time : 오후 9:42
 * Title : Partition Labels
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num763 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> partitions = new ArrayList<>();

        for (int i = 0; i < s.length(); i++){
            // 중요한 것은 마지막에 등장하는 알파벳의 위치이다.
            // 마지막에 등장하는 알파벳의 위치를 기록한다.
            map.put(s.charAt(i), i);
        }

        int lastIndex = -1; //파티션의 마지막 지점
        int startIndex = 0; //파티션의 시작지점
        for (int i = 0; i < s.length(); i++){
            //각 자리의 알파벳의 마지막 등장 시점이 파티션의 종료 지점이 된다.
            int alphaIndex = map.get(s.charAt(i)); //알파벳의 등장 시점을 기록한다.
            if (alphaIndex > lastIndex){ //현재 파티션의 마지막 지점보다 알파벳의 등장 시점이 뒤라면
                lastIndex = alphaIndex; //파티션을 확장한다.
            }
            if (i == lastIndex){ //현재 포인터의 위치가 파티션의 마지막 지점이라면, 즉 파티션 내부에서만 동일한 알파벳이 등장했다면.
                partitions.add(i - startIndex + 1); //파티션 구간 동안 있는 문자열의 길이를 기록하고
                startIndex = i + 1; //파티션의 시작지점을 갱신한다.
                lastIndex = -1; //파티션의 종료 지점을 초기화 한다.
            }
        }
        return partitions;
    }
}
