package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.uniquepaths.DpSolution;
import zhy2002.leetcode.solutions.uniquepaths.RecursiveSolution;
import zhy2002.leetcode.solutions.uniquepaths.Solution;

import static org.junit.Assert.*;

public class UniquePathsTests {

    @Test
    public void dpBasicTest(){
        basicTest(new DpSolution());
    }

    @Test
    public void recursiveBasicTest(){
        basicTest(new RecursiveSolution());
    }

    private void basicTest(Solution solution) {

        assertEquals(1, solution.uniquePaths(1, 1));
        assertEquals(1, solution.uniquePaths(1, 9));
        assertEquals(1, solution.uniquePaths(9, 1));
        assertEquals(2, solution.uniquePaths(2, 2));
        assertEquals(3, solution.uniquePaths(2, 3));
        assertEquals(6, solution.uniquePaths(3, 3));
        assertEquals(1716, solution.uniquePaths(7, 8));
    }
}
