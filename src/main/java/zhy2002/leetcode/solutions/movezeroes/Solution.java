package zhy2002.leetcode.solutions.movezeroes;

/**
 * https://leetcode.com/problems/move-zeroes/
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if(nums.length == 0)
            return;

        //find first 0
        int start = 0;
        while (start < nums.length && nums[start] != 0)
            start++;
        if(start == nums.length)
            return;

        int end = start + 1;
        while (end < nums.length) {
            if(nums[end] == 0) {
                end++;
                continue;
            }
            nums[start++] = nums[end++];
        }

        while (start < nums.length) {
            nums[start++] = 0;
        }
    }
}
