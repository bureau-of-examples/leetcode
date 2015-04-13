package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.interleavingstring.Solution;
import static org.junit.Assert.*;

public class InterleavingStringTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        assertEquals(true,solution.isInterleave("","",""));
        assertEquals(true, solution.isInterleave("a","b","ab"));
        assertEquals(true, solution.isInterleave("a","b","ba"));
        assertEquals(false, solution.isInterleave("a","b","bac"));
        assertEquals(true, solution.isInterleave("ac","b","abc"));
        assertEquals(true, solution.isInterleave("ac","bd","acbd"));
        assertEquals(true, solution.isInterleave("ac","bd","bdac"));
        assertEquals(false, solution.isInterleave("ac","bd","adbc"));
        assertEquals(true, solution.isInterleave("ac","bd","badc"));
        assertEquals(true, solution.isInterleave("ac","bd","bacd"));
        assertEquals(true, solution.isInterleave("aabcc","dbbca","aadbbcbcac"));
        assertEquals(false, solution.isInterleave("aabcc","dbbca","aadbbbaccc"));
        assertEquals(true, solution.isInterleave("ab","cde","cadeb"));
        assertEquals(true, solution.isInterleave("ab","cfde","cafdeb"));
        assertEquals(true, solution.isInterleave("aaa","bbbb","abbaabb"));
        assertEquals(true, solution.isInterleave("aaa","bbbb","bbbbaaa"));
        assertEquals(false, solution.isInterleave("caa","bdbb","bdbaacb"));
    }
}
