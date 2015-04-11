package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.decodeways.Solution;
import static org.junit.Assert.*;

public class DecodeWaysTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(1, solution.numDecodings("1"));
        assertEquals(0, solution.numDecodings("0"));
        assertEquals(1, solution.numDecodings("10"));
        assertEquals(2, solution.numDecodings("12"));
        assertEquals(3, solution.numDecodings("121"));
        assertEquals(1, solution.numDecodings("999"));
        assertEquals(2, solution.numDecodings("1999"));
        assertEquals(1, solution.numDecodings("101"));
        assertEquals(0, solution.numDecodings("100"));
    }
}
