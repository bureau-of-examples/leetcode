package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.basiccalculator.Solution;

import static org.junit.Assert.*;

public class BasicCalculatorTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(2, solution.calculate("1+1"));
        assertEquals(13, solution.calculate("12+1"));
        assertEquals(0, solution.calculate("1 - 1"));
        assertEquals(0, solution.calculate("(1 - 1)"));
        assertEquals(5, solution.calculate("5 + (1 - 1)"));
        assertEquals(9, solution.calculate("5 + (12 - 1) - 7"));
        assertEquals(9, solution.calculate("5 + ((12 - 1) - 7)"));
        assertEquals(9, solution.calculate("(5) + ((12 - 1) - 7)"));
        assertEquals(9, solution.calculate("((5) + ((12 - 1) - 7))"));
        assertEquals(12, solution.calculate("((5) + ((12 - 1) - 7)) + 3"));
    }

    @Test
    public void failedTest(){
        Solution solution = new Solution();
        assertEquals(23, solution.calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
    }

    @Test
    public void negativeTest(){
        Solution solution = new Solution();
        assertEquals(-4, solution.calculate("-5+1"));
        assertEquals(-6, solution.calculate("(-5+1)-2"));
        assertEquals(-2, solution.calculate("(-5+1)- -2"));
        assertEquals(-1, solution.calculate("(-5+1*2)- -2"));
        assertEquals(-6, solution.calculate("(-5+1)*2- -2"));
        assertEquals(-28, solution.calculate("-5*2- --3 * 6"));
        assertEquals(30, solution.calculate("-5*(2- --3) * 6"));
        assertEquals(52, solution.calculate("22+-5*(2- --3) * 6"));
        assertEquals(50, solution.calculate("-2+22+-5*(2- --3) * 6"));
        assertEquals(44, solution.calculate("-2+22+-5*(2- --3) * 6-6"));
        assertEquals(48, solution.calculate("-1*-2+22+-5*(2- --3) * 6-6"));
        assertEquals(3682, solution.calculate("(1*(2+(3*4-5)+6*(-2*(-3+6*17)+5)-71)*3-22)*-1"));

    }
}
