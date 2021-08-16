package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-16
 * Time : 오후 7:08
 * Title : Maximum Units on a Truck
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */
public class Num1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int total_unit = 0;
        int left_boxes = truckSize;
        for (int[] boxType : boxTypes) {
            if (boxType[0] <= left_boxes){
                total_unit += boxType[0] * boxType[1];
                left_boxes -= boxType[0];
            }else{
                total_unit += left_boxes * boxType[1];
                left_boxes -= left_boxes;
            }
            if (left_boxes == 0){
                break;
            }
        }
        return total_unit;
    }
}
