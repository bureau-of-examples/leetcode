package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.largestrectangleinhistogram.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleAreaTest {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.largestRectangleArea(new int[]{}));
        assertEquals(100, solution.largestRectangleArea(new int[]{100}));
        assertEquals(100, solution.largestRectangleArea(new int[]{1,2,100}));
        assertEquals(100, solution.largestRectangleArea(new int[]{1,100,2}));
        assertEquals(100, solution.largestRectangleArea(new int[]{100,2,1}));
        assertEquals(30, solution.largestRectangleArea(new int[]{10,11,12}));
        assertEquals(80, solution.largestRectangleArea(new int[]{10,11,12,5,50,40,20}));
        assertEquals(100, solution.largestRectangleArea(new int[]{10,11,12,5,50,40,20,20,25}));
    }
}
