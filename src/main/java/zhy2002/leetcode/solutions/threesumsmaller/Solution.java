package zhy2002.leetcode.solutions.threesumsmaller;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/
 *
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2. Because there are two triplets which sums are less than 2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up:
 * Could you solve it in O(n2) runtime?
 */
public class Solution {

    //sort the array first. For each number, use two pointers to check how many pairs can be '3sum smaller' with it.
    //2 sum smaller algorithm see comments below.
    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);
        int count = 0;
        int lastStart = nums.length - 3;
        for(int i=0; i<= lastStart; i++){ //count all triplets with smallest value being nums[i]
            int sumUpperBound = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            //calculate pairs smaller than sumUpperBound in the range of [start, end]
            while (start <= end){
//                if(nums[start] + nums[start] >= sumUpperBound) //early termination
//                    break;
                if(nums[start] + nums[end] < sumUpperBound){ //found a pair
                    count += end - start; //add all pairs starting from start and smaller than sumUpperBound
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
