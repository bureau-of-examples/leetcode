package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.maximumsubarray.DNCSolution;
import zhy2002.leetcode.solutions.maximumsubarray.LinearSolution;
import zhy2002.leetcode.solutions.maximumsubarray.SubtractSolution;
import zhy2002.leetcode.solutions.maximumsubarray.Solution;

import static org.junit.Assert.*;

public class MaximumSubarrayTests {

    @Test
    public void linearBasicTest() {
        Solution solution = new LinearSolution();
        basicTest(solution);
    }

    @Test
    public void subtractBasicTest(){
        basicTest(new SubtractSolution());
    }

    @Test
    public void dncBasicTest(){
        basicTest(new DNCSolution());
    }

    private void basicTest(Solution solution) {
        assertEquals(10, solution.maxSubArray(new int[]{1, 2, 3, 4}));
        assertEquals(-1, solution.maxSubArray(new int[]{-1}));
        assertEquals(-1, solution.maxSubArray(new int[]{-1,-2,-1}));
        assertEquals(2, solution.maxSubArray(new int[]{-1,-2,2}));
        assertEquals(10, solution.maxSubArray(new int[]{4, 3, 2, 1}));
        assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(8, solution.maxSubArray(new int[]{3, -4, 5, 2, -3, 4, -2}));
        assertEquals(10, solution.maxSubArray(new int[]{3, -4, 5, -1,3, 2, -3, 4, -2}));
    }

}
