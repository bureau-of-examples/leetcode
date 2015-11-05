package zhy2002.leetcode.solutions.twosumii;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {

    /**
     * Use two pointers start and end pointing to the beginning and end of the list.
     * If these two values sum to target, then return them.
     * If the sum is greater than target,then decrease end
     * else the sum is smaller than target, then increase start
     * the iteration invariant is: all pairs with an index in (..., start) or (end, ...) do not sum to target.
     * Proof:
     * If the sum is greater than target, then:
     * 1) value of [start, end) + value of end > target
     * 2) value of (..., start) + value of end is not target (assumption)
     * So we know value end in [end, ...) is not target
     * additional we know 3) value of end + value of (end, ...) is not target (assumption)
     * The conclusion is no pair has end as an index sum to target.
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null)
            return null;

        int start = 0, end = numbers.length - 1;
        while (start < end) {
            long sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }
}
