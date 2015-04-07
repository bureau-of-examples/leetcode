package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.climbingstairs.DpSolution;
import zhy2002.leetcode.solutions.climbingstairs.RecursiveSolution;
import org.junit.Test;
import static org.junit.Assert.*;


public class ClimbingStairsTests {

    @Test
    public void comparisonTest(){

        DpSolution dpSolution = new DpSolution();
        RecursiveSolution recursiveSolution = new RecursiveSolution();
        for(int i=0; i<30;i++){
            int ret1 = dpSolution.climbStairs(i);
            int ret2 = recursiveSolution.climbStairs(i);
            assertEquals(ret1, ret2);
        }
    }
}
