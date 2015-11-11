package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.palindromepartitioningii.Solution;

import static org.junit.Assert.*;

public class PalindromePartitioningIITests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(0, solution.minCut(""));
        assertEquals(0, solution.minCut("a"));
        assertEquals(1, solution.minCut("ab"));
        assertEquals(1, solution.minCut("abac"));
    }
}
