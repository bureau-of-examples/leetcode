package zhy2002.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            threeSum(result, nums, i, target);
        }
        return result;
    }

    private void threeSum(List<List<Integer>> result, int[] nums, int i, int target) {
        for (int j = i + 1; j <nums.length - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j-1]) {
                continue;
            }
            twoSum(result, nums, i, j, target);
        }
    }

    private void twoSum(List<List<Integer>> result, int[] nums, int i, int j, int target) {
        int start = j + 1, end = nums.length -1;
        int target2 = target - nums[i] - nums[j];
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target2) {
                result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                start++;
                end--;
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
            } else if (sum < target2) {
                start++;
            } else {
                end--;
            }
        }
    }
}


public class FourSum {

    public static void main(String[] args) {
        new Solution().fourSum(new int[] {1,2,3,4}, 10);
    }
}
