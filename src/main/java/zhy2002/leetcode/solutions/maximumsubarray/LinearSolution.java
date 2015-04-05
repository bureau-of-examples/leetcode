package zhy2002.leetcode.solutions.maximumsubarray;

/**
 * Find maximum sub-array end at i.
 */
public class LinearSolution implements Solution {

    @Override
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException("A");

        int maxEndsI_1 = A[0];
        int max = maxEndsI_1;

        for (int i = 1; i < A.length; i++) {
            int maxEndsAtI;
            if(maxEndsI_1 <= 0)
                maxEndsAtI = A[i];
            else
                maxEndsAtI = maxEndsI_1 + A[i];
            if (max < maxEndsAtI)
                max = maxEndsAtI;
            maxEndsI_1 = maxEndsAtI;
        }
        return max;
    }
}
