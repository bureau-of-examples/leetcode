package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.minimumpathsum.DpSolution;
import zhy2002.leetcode.solutions.minimumpathsum.RecursiveSolution;
import zhy2002.leetcode.solutions.minimumpathsum.Solution;
import static org.junit.Assert.*;

public class MinimumPathSumTests {

    @Test
    public void recursiveTest(){
        basicTest(new RecursiveSolution());
    }

    @Test
    public void dpBasicTest(){
        basicTest(new DpSolution());
    }

    private void basicTest(Solution solution){
        int[][] grid = {
                {1,3, 2},
                {2,0, 1},
                {3,2, 1}
        };
        assertEquals(5, solution.minPathSum(grid));

        int[][] grid2 = {
                {1,3, 2, 0},
                {2,0, 1, 1},
                {3,2, 1, 1}
        };
        assertEquals(6, solution.minPathSum(grid2));
    }

    @Test
    public void randomComparisonTest(){
        DpSolution dpSolution = new DpSolution();
        RecursiveSolution recursiveSolution = new RecursiveSolution();

        for(int i=0; i<10; i++){
            int[][] mat = Utils.randIntMatrix(10,20);
            int ret1 = dpSolution.minPathSum(mat);
            int ret2 = recursiveSolution.minPathSum(mat);
            assertEquals(ret1, ret2);
        }
    }


}
