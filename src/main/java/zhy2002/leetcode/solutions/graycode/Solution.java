package zhy2002.leetcode.solutions.graycode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * Recursion:
 * prefix 0 (gray code here) <- last (..) is the same as
 * prefix 1 (reverse gray code here) <- first (...)
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        if (n < 0 || n > 32)
            return null;

        List<Integer> result = new ArrayList<>();
        addGrayCode(result, 0, n, false);
        return result;
    }

    public void addGrayCode(List<Integer> result, int prefix, int n, boolean reverseOrder) {

        if (n == 0) {
            result.add(prefix);
            return;
        }
        if (reverseOrder) {
            addGrayCode(result, prefix | 1 << (n - 1), n - 1, !reverseOrder);
            addGrayCode(result, prefix, n - 1, reverseOrder);

        } else {
            addGrayCode(result, prefix, n - 1, reverseOrder);
            addGrayCode(result, prefix | 1 << (n - 1), n - 1, !reverseOrder);
        }
    }

}
