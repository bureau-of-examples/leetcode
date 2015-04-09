package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.simplifypath.Solution;

import static org.junit.Assert.*;

public class SimplifyPathTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals("", solution.simplifyPath(""));
        assertEquals("/", solution.simplifyPath("/"));
        assertEquals("/", solution.simplifyPath("//"));
        assertEquals("/a", solution.simplifyPath("/a/"));
        assertEquals("/a", solution.simplifyPath("/./a/"));
        assertEquals("/", solution.simplifyPath("/../"));
        assertEquals("/a", solution.simplifyPath("/a/b/.."));
        assertEquals("/a/c", solution.simplifyPath("/a/b//../c/"));
        assertEquals("/a/c", solution.simplifyPath("/a/b/../c/."));
        assertEquals("/", solution.simplifyPath("/a/./../b/../"));

    }
}
