package zhy2002.leetcode.solutions.reversebits;

/**
 * https://leetcode.com/problems/reverse-bits/
 * Copy the bits one by one in reverse order.
 * To speed up: pre-calculate byte reverse map and do it byte by byte.
 */
public class Solution {

    public int reverseBits(int n) {

            int result = 0;

            for (int i = 0; i < 32; i++) {
                result |= ((n >> i) << 31) >>> i;
            }
            return result;

    }
}
