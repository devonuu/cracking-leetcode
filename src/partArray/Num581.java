package partArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-25
 * Time : 오전 11:07
 * Title : Shortest Unsorted Continuous Subarray
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) return 0; //길이가 1인 경우 바꿀것이 없다.

        int index = 0;
        int value = 100001; //최대값
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && value > nums[i + 1]){
                index = i + 1;
                value = nums[i + 1];
            }
        }

        if (value == 100001) return 0; //이미 정렬이 되어 있는 경우 바꿀 것이 없다.

        int startIdx = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (value < nums[i]) startIdx = i;
        }

        index = 0;
        value = -100001; //최소값
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && value <= nums[i]){ //값이 같아도 그 사이에 작은 값이 있다면 정렬의 대상이 된다.
                index = i;
                value = nums[i];
            }
        }

        int endIdx = nums.length - 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (value <= nums[i]) { //값이 같아도 그 사이에 작은 값이 있다면 정렬의 대상이 된다.
                endIdx = i - 1;
                break;
            }
        }

        int answer = endIdx - startIdx + 1;
        return answer;
    }

    @Test
    void 테스트(){
        Assertions.assertEquals(36, findUnsortedSubarray(new int[]{-100,-99,-98,-97,-96,-95,-94,-93,-92,-91,-90,-89,-88,-87,-86,-85,-84,-83,-82,-81,-80,-79,-78,-77,-76,-75,-65,-53,-73,-63,-67,-61,-39,-58,-56,-55,-68,-66,-74,-49,-60,-51,-62,-42,-47,-54,-43,-71,-64,-59,-45,-69,-57,-41,-70,-44,-46,-50,-48,-72,-52,-40,-38,-37,-36,-35,-34,-33,-32,-31,-30,-29,-28,-27,-26,-25,-24,-23,-22,-21,-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99}));
        Assertions.assertEquals(4, findUnsortedSubarray(new int[]{3,2,3,2,4}));
        Assertions.assertEquals(2, findUnsortedSubarray(new int[]{1,3,2,3,3}));
        Assertions.assertEquals(4, findUnsortedSubarray(new int[]{1,3,2,2,2}));
        Assertions.assertEquals(3, findUnsortedSubarray(new int[]{2,3,3,2,4}));
        Assertions.assertEquals(2, findUnsortedSubarray(new int[]{1,3,2,4,5}));
        Assertions.assertEquals(2, findUnsortedSubarray(new int[]{2,1}));
        Assertions.assertEquals(0, findUnsortedSubarray(new int[]{1,2,3,4}));
    }
}
