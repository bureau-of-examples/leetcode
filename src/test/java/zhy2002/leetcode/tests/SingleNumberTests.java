package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.singlenumber.Solution;
import zhy2002.leetcode.solutions.singlenumber.TleSolution;
import zhy2002.leetcode.solutions.singlenumber.XorSolution;

import static org.junit.Assert.*;

public class SingleNumberTests {

    @Test
    public void xorBasicTest(){
        basicTest(new XorSolution());
    }

    @Test
    public void tleBasicTest(){
        basicTest(new TleSolution());
    }
    public void basicTest(Solution solution){
        assertEquals(5, solution.singleNumber(new int[]{5}));
        assertEquals(5, solution.singleNumber(new int[]{6,6,5}));
        assertEquals(5, solution.singleNumber(new int[]{5,6,6}));
        assertEquals(5, solution.singleNumber(new int[]{6,5,6}));
        assertEquals(5, solution.singleNumber(new int[]{6,4,5,6,4}));
        assertEquals(5, solution.singleNumber(new int[]{-1,5,-2,-1,-2}));
    }
}
