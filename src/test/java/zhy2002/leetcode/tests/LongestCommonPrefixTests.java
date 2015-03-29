package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestcommonprefix.Solution;

import static org.junit.Assert.*;

public class LongestCommonPrefixTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals("a", solution.longestCommonPrefix(new String[]{"a", "ab"}));
        assertEquals("", solution.longestCommonPrefix(new String[]{"a", "bb"}));
        assertEquals("a", solution.longestCommonPrefix(new String[]{"adec", "aedac", "ada"}));
        assertEquals("ad", solution.longestCommonPrefix(new String[]{"adec", "adac", "ada"}));
        assertEquals("defab", solution.longestCommonPrefix(new String[]{"defabc", "defabcde", "defab"}));
    }
}
