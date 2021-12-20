package partArray;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Project : algorithm
 * Created by gonuu
 * Date : 2021-12-06
 * Time : 오전 7:59
 * Title :
 * Blog : http://devonuu.tistory.com
 * Github : http://github.com/devonuu
 */

public class Review {
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left <= right){
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public int[] moveZeros(int[] nums){
        int zeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                swap(nums, zeroIdx, i);
                zeroIdx++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public int findPivot(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int lastPivot = 0;
        int pivot = 0;
        for (int i = 0; i < nums.length; i++) {
            pivot = nums[i];
            sum -= pivot;
            leftSum += lastPivot;
            if (leftSum == sum){
                return pivot;
            }
            lastPivot = pivot;
        }
        return -1;
    }

    public int minimumSizeSubarraySum(int[] nums, int s){
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count++;

            while (sum >= s){
                min = Math.min(min, count);
                sum -= nums[left];
                left++;
                count--;
            }
        }
        if (min == Integer.MAX_VALUE) return 0;
        else return min;
    }

    public int findUnsortedSubarray(int[] nums) {
        // -> 방향으로 가면서 꺾이는 부분 중 가장 작은 부분 찾기
        // -> 방향으로 가면서 등장하는 부분 중 최소값 보다 작은 index 찾기
        // <- 방향으로 가면서 꺾이는 부분 중 가장 큰 부분 찾기
        // <- 방향으로 가면서 등장하는 부분 중 최대값 보다 큰 index 찾기
        if (nums.length <= 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]){
                min = Math.min(min, nums[i]);
            }
        }

        if (min == Integer.MAX_VALUE) return 0;

        for (; left < nums.length; left++) {
            if (min < nums[left]) {
                break;
            }
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] > nums[i]){
                max = Math.max(max, nums[i - 1]);
            }
        }

        for (; right > 0; right--) {
            if (max > nums[right]){
                break;
            }
        }

        return right - left + 1;
    }

    @Test
    void findUnsortedSubarrayTest(){
        Assertions.assertEquals(5, findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        Assertions.assertEquals(0, findUnsortedSubarray(new int[]{1,2,3,4}));
        Assertions.assertEquals(0, findUnsortedSubarray(new int[]{1}));
    }
}
