package partArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project : algorithm Created by gonuu
 * Date : 2021-08-28
 * Time : 오전 10:46
 * Title : 4Sum
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Num18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int a = 0;
        int b = 1;
        int c = 2;
        int d = nums.length - 1;

        Set<String> set = new HashSet<>();

        while (a < nums.length - 3){
            while (b < nums.length - 2){
                while (c < d){
                    int tmp = nums[a] + nums[b] + nums[c] + nums[d];
                    if (tmp == target){
                        StringBuilder builder = new StringBuilder();
                        builder.append(nums[a]).append("_")
                            .append(nums[b]).append("_")
                            .append(nums[c]).append("_")
                            .append(nums[d]);
                        set.add(builder.toString());
                        d--;
                    }else if (tmp > target){
                        d--;
                    }else {
                        c++;
                    }
                }
                b++;
                c = b + 1;
                d = nums.length - 1;
            }
            a++;
            b = a + 1;
            c = b + 1;
            d = nums.length - 1;
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (String s : set) {
            String[] split = s.split("_");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            answer.add(list);
        }

        return answer;
    }

    /*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);

        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])
                if (s.contains(target - nums[i]))
                    res.add(Arrays.asList(target - nums[i], nums[i]));
            s.add(nums[i]);
        }

        return res;
    }
    * */
}
