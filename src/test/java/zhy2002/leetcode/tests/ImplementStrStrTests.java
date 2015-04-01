package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.implementstrstr.Solution;

import static org.junit.Assert.*;

public class ImplementStrStrTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(0, solution.strStr("", ""));
        assertEquals(-1, solution.strStr("", "s"));
        assertEquals(0, solution.strStr("abbac", "ab"));
        assertEquals(3, solution.strStr("abbac", "ac"));
        assertEquals(4, solution.strStr("abbbabbbb", "abbbb"));
        assertEquals(4, solution.strStr("aabbdabb", "dabb"));
        assertEquals(3, solution.strStr("ADCADCDD", "ADCDD"));
        assertEquals(3, solution.strStr("abcfaadefaadsfwer", "faa"));
        assertEquals(12, solution.strStr("abcdebcdebcdfbcd", "fbcd"));
    }
}

