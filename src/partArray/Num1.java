package partArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-28
 * Time : 오전 10:44
 * Title : 2Sum
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num1 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], i});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[0] == t2[0]){
                    return t1[1] - t2[1];
                }
                return t1[0] - t2[0];
            }
        });

        while (left < right){
            int sum = list.get(left)[0] + list.get(right)[0];
            if (sum == target) break;
            else if (sum > target) right--;
            else left++;
        }
        int[] answer = {list.get(left)[1], list.get(right)[1]};
        return answer;
    }

    @Test
    void 테스트(){
        Assertions.assertArrayEquals(new int[]{0,1}, twoSum(new int[]{3,3}, 6));
        Assertions.assertArrayEquals(new int[]{1,2}, twoSum(new int[]{3,2,4}, 6));
    }
}
