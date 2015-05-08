package zhy2002.leetcode.solutions.bitwiseandofnumbersrange;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * For the lowest bit for each bit:
 * check if this bit can be and to 0; if no then finished
 * if yes then set it 0 and check the next bit
 * ?????0000 can be and to 0 iff n > ????11111
 */
public class Solution {

    public int rangeBitwiseAnd(int m, int n) {

        int trailing0s = 0;
        int mask = 0;

        while (m > 0 && n > (m | mask)) {
            m &= ~(1 << trailing0s);
            trailing0s++;
            mask <<= 1;
            mask |= 1;
        }
        return m;

    }

}
