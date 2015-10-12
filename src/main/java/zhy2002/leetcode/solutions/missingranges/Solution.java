package zhy2002.leetcode.solutions.missingranges;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/missing-ranges/
 */
public class Solution {

    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            addRange(result, lower, upper);
            return result;
        }

        if (A[0] != lower) {
            addRange(result, lower, A[0] - 1);
        }

        for (int i = 1; i < A.length; i++) {
            addRange(result, A[i - 1] + 1, A[i] - 1);
        }

        if (A[A.length - 1] != upper) {
            addRange(result, A[A.length - 1] + 1, upper);
        }

        return result;
    }

    private void addRange(List<String> result, int lower, int upper) {
        if (lower > upper)
            return;
        result.add(lower == upper ? String.valueOf(lower) : lower + "->" + upper);
    }

}
