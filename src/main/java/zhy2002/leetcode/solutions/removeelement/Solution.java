package zhy2002.leetcode.solutions.removeelement;

/**
 * https://leetcode.com/problems/remove-element/
 * Use the last element to fill the value.
 */
public class Solution {

    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0)
            return 0;

        int lastIndex = A.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == elem) {
                if (i != lastIndex) {
                    A[i] = A[lastIndex];
                }
                lastIndex--;
            }
        }

        return lastIndex + 1;
    }
}
