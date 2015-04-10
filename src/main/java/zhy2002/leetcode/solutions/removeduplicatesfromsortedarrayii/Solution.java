package zhy2002.leetcode.solutions.removeduplicatesfromsortedarrayii;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Count duplicates.
 */
public class Solution {

    public int removeDuplicates(int[] A) {
        if (A == null)
            return -1;

        if (A.length <= 2)
            return A.length;

        int solidIndex = 0;
        int sameCount = 1;
        for (int currentIndex = 1; currentIndex < A.length; currentIndex++) {
            if (A[solidIndex] == A[currentIndex]) {
                sameCount++;
                if (sameCount > 2)
                    continue;
            } else {
                sameCount = 1;
            }

            int nextSolidIndex = solidIndex + 1;
            if (currentIndex != nextSolidIndex) {
                A[nextSolidIndex] = A[currentIndex];
            }
            solidIndex = nextSolidIndex;
        }
        return solidIndex + 1;
    }
}
