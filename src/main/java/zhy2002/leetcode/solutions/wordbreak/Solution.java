package zhy2002.leetcode.solutions.wordbreak;

import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * Dynamic programming.
 * Can break at i iff:
 * there is a word of length 1 in dict and [0,i-1] can break OR
 * there is a word of length 2 in dict and [0,i-2] can break OR
 * ...
 */
public class Solution {

    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] canBreakB4 = new boolean[s.length() + 1];//if [0, i) can break into words in dict.
        canBreakB4[0] = true;
        for (int len = 1; len <= s.length(); len++) {
            int index = len - 1;
            for (int i = index; i >= 0; i--) {
                if (canBreakB4[i] && dict.contains(s.substring(i, len))) {
                    canBreakB4[len] = true;
                    break;
                }
            }
        }
        return canBreakB4[s.length()];

    }
}
