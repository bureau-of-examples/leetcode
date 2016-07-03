package zhy2002.leetcode.additional.swapwithouttempvariable;

import zhy2002.leetcode.additional.common.IntPair;

/**
 * CCI question 19.1:
 * swap two variables without temp variable.
 */
public class Solution {

    public void swap(IntPair pair) {
        pair.left ^= pair.right;
        pair.right ^= pair.left;
        pair.left ^= pair.right;
    }
}
