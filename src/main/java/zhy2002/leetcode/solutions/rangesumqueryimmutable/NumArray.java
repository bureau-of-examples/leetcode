package zhy2002.leetcode.solutions.rangesumqueryimmutable;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class NumArray {

    private long[] sums;

    public NumArray(int[] nums) {
        sums = new long[nums.length];
        long sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return (int)(sums[j] - (i == 0? 0 : sums[i-1]));
    }
}
