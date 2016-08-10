package zhy2002.leetcode.solutions.rangeaddition;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 * Example:
 * Given:
 * length = 5,
 * updates = [
 * [1,  3,  2],
 * [2,  4,  3],
 * [0,  2, -2]
 * ]
 * <p>
 * Output:
 * [-2, 0, 3, 5, 3]
 * Explanation:
 * Initial state:
 * [ 0, 0, 0, 0, 0 ]
 * After applying operation [1, 3, 2]:
 * [ 0, 2, 2, 2, 0 ]
 * After applying operation [2, 4, 3]:
 * [ 0, 2, 5, 5, 3 ]
 * After applying operation [0, 2, -2]:
 * [-2, 0, 3, 5, 3 ]
 */
public class Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
        //after this result[i] records a change to be applied to all subsequent elements.
        int[] result = new int[length];
        for (int[] operation : updates) {
            result[operation[0]] += operation[2];
            if (operation[1] + 1 < length) {
                result[operation[1] + 1] -= operation[2];
            }
        }

        int delta = 0;
        for (int i = 0; i < result.length; i++) {
            int currentDelta = delta;
            delta += result[i];
            result[i] += currentDelta;
        }

        return result;
    }
}
