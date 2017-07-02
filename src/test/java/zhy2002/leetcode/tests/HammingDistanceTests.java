package zhy2002.leetcode.tests;

/**
 * https://leetcode.com/problems/hamming-distance/#/description
 */
public class HammingDistanceTests {

    public class Solution {
        public int hammingDistance(int x, int y) {
            int mask = Integer.MIN_VALUE;
            int dist = 0;
            for (int i = 0; i < 32; i++) {
                int xBit = x & mask;
                int yBit = y & mask;
                if (xBit != yBit) {
                    dist++;
                }
                mask = mask >>> 1;
            }
            return dist;
        }
    }
}
