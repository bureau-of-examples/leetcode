package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.solutions.jumpgame.GreedySolution;
import zhy2002.leetcode.solutions.jumpgame.Solution;
import static org.junit.Assert.*;

public class JumpGameTests {

    @Test
    public void greedyBasicTest(){
        basicTest(new GreedySolution());
    }

    private void basicTest(Solution solution){
        assertEquals(true, solution.canJump(new int[]{0}));
        assertEquals(true, solution.canJump(new int[]{1,0}));
        assertEquals(true, solution.canJump(new int[]{2, 0, 0}));
        assertEquals(false, solution.canJump(new int[]{1,0,2,0,0}));
        assertEquals(true, solution.canJump(new int[]{2, 3, 1, 1, 4}));
        assertEquals(false, solution.canJump(new int[]{3,2,1,0,4}));
    }
}
