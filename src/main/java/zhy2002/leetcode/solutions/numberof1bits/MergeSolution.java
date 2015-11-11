package zhy2002.leetcode.solutions.numberof1bits;

/**
 * Split the dword into two parts:
 * ....0?0?0?0? and ....x0x0x0x0
 * Then do add up:
 * ....0?0?0?0?
 *  ....x0x0x0x (0 <- this last 1 bit is discarded)
 * Now every 2 bits represents the number of 1s in these two bits
 *
 * Again split the dward into two parts:
 * ....00??00?? and ....??00??00
 * Then do add up:
 * ....00??00??
 *   ....??00??(00 <- these last two bits are discarded)
 *   Now every 4 bits represents the number of 1s in these 4 bits
 *
 *   Continue until every 32 bits represents the number of 1s in these 32 bits.
 */
public class MergeSolution implements Solution {

    public int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >>> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + ((n >>> 8) & 0x00FF00FF);
        n = (n & 0x0000FFFF) + ((n >>> 16) & 0x0000FFFF);
        return n;

    }
}
