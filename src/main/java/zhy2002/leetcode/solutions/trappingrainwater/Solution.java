package zhy2002.leetcode.solutions.trappingrainwater;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class Solution {

    public int trap(int[] A) {

        int[] leftMax = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                leftMax[i] = 0;
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);//highest to the left
            }
        }

        int[] rightMax = new int[A.length];
        for (int j = A.length - 1; j >= 0; j--) {
            if (j == A.length - 1) {
                rightMax[j] = 0;
            } else {
                rightMax[j] = Math.max(rightMax[j + 1], A[j + 1]);//highest to the right
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - A[i]);//add by layer (0-1, 1-2, 2-3, ...)
        }

        return result;
    }
}
