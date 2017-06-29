package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.addbinary.Solution;

import static org.junit.Assert.*;

public class AddBinaryTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals("11", solution.addBinary("10", "1"));
        assertEquals("1000", solution.addBinary("111", "1"));
        assertEquals("110", solution.addBinary("101", "1"));
        assertEquals("10001", solution.addBinary("1100", "101"));
        assertEquals("101101", solution.addBinary("11010", "10011"));
    }

}
