package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.romantointeger.Solution;
import static org.junit.Assert.*;

public class RomanToIntegerTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(1, solution.romanToInt("I"));
        assertEquals(2, solution.romanToInt("II"));
        assertEquals(3, solution.romanToInt("III"));
        assertEquals(4, solution.romanToInt("IV"));
        assertEquals(5, solution.romanToInt("V"));
        assertEquals(6, solution.romanToInt("VI"));
        assertEquals(7, solution.romanToInt("VII"));
        assertEquals(8, solution.romanToInt("VIII"));
        assertEquals(9, solution.romanToInt("IX"));
        assertEquals(10, solution.romanToInt("X"));
        assertEquals(11, solution.romanToInt("XI"));
        assertEquals(12, solution.romanToInt("XII"));
        assertEquals(2012, solution.romanToInt("MMXII"));
        assertEquals(2412, solution.romanToInt("MMCDXII"));
        assertEquals(1954, solution.romanToInt("MCMLIV"));




    }
}
