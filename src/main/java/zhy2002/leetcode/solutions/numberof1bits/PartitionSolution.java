package zhy2002.leetcode.solutions.numberof1bits;

/**
 * Add up the number of 1 bits in every 4 bits.
 */
public class PartitionSolution implements Solution {

    //number of 1 bits in 0x0 to 0xF.
    private static final int[] counts = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    public int hammingWeight(int n) {
        int result = 0;
        result += counts[n & 0xf];
        result += counts[n >> 4 & 0xf];
        result += counts[n >> 8 & 0xf];
        result += counts[n >> 12 & 0xf];
        result += counts[n >> 16 & 0xf];
        result += counts[n >> 20 & 0xf];
        result += counts[n >> 24 & 0xf];
        result += counts[n >> 28 & 0xf];
        return result;
    }
}
