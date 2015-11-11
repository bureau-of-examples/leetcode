package zhy2002.leetcode.solutions.bitwiseandofnumbersrange;

public class CleanSolution implements Solution {

    /**
     * From the right side check if a bit in n will be 0, if so set it 0.
     * If m == n, the result is m.
     * If n > m, n's right most bit will be set to 0. E.g. if n is ???10000, then ???00000 is in range.
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) { //turn off right most bit of n until it is <= m
            n = n & n - 1;
        }
        return m & n;
    }


}
