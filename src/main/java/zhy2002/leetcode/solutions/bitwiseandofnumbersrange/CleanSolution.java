package zhy2002.leetcode.solutions.bitwiseandofnumbersrange;

public class CleanSolution implements Solution {

    /**
     * From the right side check if a bit in n will be 0, if so set it 0.
     * If m == n, the result is m.
     * If n > m, n's right most bit will be set to 0. E.g. if n == ???10000 > m, then ???01111 is in range.
     * Termination:
     * 1) If the first 1 bit in n is to the left of the first 1 bit in m, then we have n > m until this bit is cleared.
     * 2) If the first 1 bit in n is at the same position as the first 1 bit in m, we have:
     * m: ....0???? (dot means this bit is the same)
     * n: ....10000 (we set 0 from the right side)
     * If we clear the 1 bit, we get the common part of all numbers.
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) { //turn off right most bit of n until it is <= m
            n = n & n - 1;
        }
        return n;
    }


}
