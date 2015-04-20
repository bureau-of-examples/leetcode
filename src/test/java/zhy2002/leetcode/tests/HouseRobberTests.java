package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.houserobber.*;
import static org.junit.Assert.*;

public class HouseRobberTests {

    @Test
    public void topDownBasicTest(){
        basicTest(new TopDownSolution());
    }

    @Test
    public void bottomUpBasicTest(){
        basicTest(new BottomUpSolution());
    }

    private void basicTest(Solution solution){
        assertEquals(0, solution.rob(new int[]{}));
        assertEquals(5, solution.rob(new int[]{5}));
        assertEquals(5, solution.rob(new int[]{5,4}));
        assertEquals(8, solution.rob(new int[]{4,5,4}));
        assertEquals(8, solution.rob(new int[]{4,5,4,2}));
        assertEquals(11, solution.rob(new int[]{4,5,4,6,2}));
        assertEquals(11, solution.rob(new int[]{4,5,4,6,2}));
        assertEquals(35, solution.rob(new int[]{10,2,5,16,2,9}));

    }
}
