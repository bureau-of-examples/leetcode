package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.solutions.dividetwointegers.Solution;
import zhy2002.leetcode.solutions.dividetwointegers.NaiveSolution;
import zhy2002.leetcode.solutions.dividetwointegers.QuickSolution;

import static org.junit.Assert.*;

public class DivideTwoIntegersTests {

    @Test
    public void naiveSolutionBasicTest(){
        basicTest(new NaiveSolution());
    }

    @Test
    public void solutionBasicTest(){
        basicTest(new QuickSolution());
    }

    private void basicTest(Solution baseSolution){
        assertEquals(0, baseSolution.divide(0, 100));
        assertEquals(1, baseSolution.divide(100, 100));
        assertEquals(1, baseSolution.divide(-100, -100));
        assertEquals(-1, baseSolution.divide(100, -100));
        assertEquals(-1, baseSolution.divide(-100, 100));
        assertEquals(1, baseSolution.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(0, baseSolution.divide(Integer.MAX_VALUE, Integer.MIN_VALUE));
        assertEquals(-Integer.MAX_VALUE, baseSolution.divide(Integer.MAX_VALUE, -1));
        assertEquals(-1, baseSolution.divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, baseSolution.divide(Integer.MIN_VALUE, 1));
        assertEquals(Integer.MAX_VALUE, baseSolution.divide(Integer.MIN_VALUE, -1));
        assertEquals(4, baseSolution.divide(8, 2));
        assertEquals(4, baseSolution.divide(9, 2));
        assertEquals(3, baseSolution.divide(16, 5));
        assertEquals(-1073741824, baseSolution.divide(Integer.MIN_VALUE, 2));
        assertEquals(847124/23, baseSolution.divide(847124, 23));
        assertEquals(6754892/-113, baseSolution.divide(6754892, -113));
        assertEquals(3, baseSolution.divide(526998875, 171772388));
        assertEquals(-1, baseSolution.divide(2147483647, -1419057124));
        assertEquals(0, baseSolution.divide(-690731771, -1401361801));

    }


}
