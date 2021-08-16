package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-16
 * Time : 오후 10:14
 * Title : Gas Station
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int carGas = 0;
        for (int i = 0; i < gas.length; i++){
            carGas += gas[i];
            carGas -= cost[i];
        }

        if (carGas < 0) return -1;

        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
            indexList.add(i);
        }
        for (int i = 0; i < gas.length; i++) {
            indexList.add(i);
        }

        int startIndex = 0;
        int travelCount = 0;
        carGas = 0;
        while (startIndex < gas.length){
            carGas += (gas[indexList.get(startIndex + travelCount)] - cost[indexList.get(startIndex + travelCount)]);
            if (carGas < 0){
                startIndex++;
                travelCount = 0;
                carGas = 0;
            }else{
                travelCount++;
            }
            if (travelCount == gas.length){
                return startIndex;
            }
        }
        return startIndex;
    }
}
