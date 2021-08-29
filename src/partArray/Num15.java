package partArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-08-28
 * Time : 오전 10:44
 * Title : 3Sum
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);

        Set<String> set = new HashSet<>();
        for (int targetIndex = 0; targetIndex < nums.length; targetIndex++) {
            int left = targetIndex + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[targetIndex] + nums[left] + nums[right];
                if (sum == 0){
                    StringBuilder builder = new StringBuilder();
                    builder.append(nums[targetIndex]).append("_")
                        .append(nums[left]).append("_")
                        .append(nums[right]);
                    if (!set.contains(builder.toString())){
                        set.add(builder.toString());
                    }
                    right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (String s : set) {
            String[] split = s.split("_");
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(split[0]));
            list.add(Integer.parseInt(split[1]));
            list.add(Integer.parseInt(split[2]));
            answer.add(list);
        }

        return answer;
    }

    @Test
    void 테스트(){
        threeSum(new int[]{0, 0, 0, 0});
    }
}
