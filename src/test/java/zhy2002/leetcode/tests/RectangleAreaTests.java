package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.rectanglearea.Solution;
import static org.junit.Assert.*;

public class RectangleAreaTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(37, solution.computeArea(0,0,5,5,2,10,8,12));
        assertEquals(15, solution.computeArea(0,2,5,5,0,2,5,5));
        assertEquals(18, solution.computeArea(-1,2,5,5,0,2,5,5));
        assertEquals(18, solution.computeArea(-1,2,4,5,0,2,5,5));
    }
}
