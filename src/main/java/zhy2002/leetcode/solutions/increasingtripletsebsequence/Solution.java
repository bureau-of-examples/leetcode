package zhy2002.leetcode.solutions.increasingtripletsebsequence;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * <p>
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class Solution {

    //maintain the minimum value r that has a smaller predecessor.
    //if we find a value greater than r then there is a triplet.
    public boolean increasingTriplet(int[] nums) {

        int min = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num <= min) {
                min = num;
            } else if(num <= r) {
                r = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
