package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.houserobberii.Solution;

import static org.junit.Assert.*;

public class HouseRobberIITests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(1, solution.rob(new int[]{1}));
        assertEquals(2, solution.rob(new int[]{1,2}));
        assertEquals(5, solution.rob(new int[]{1,5,1}));
        assertEquals(5, solution.rob(new int[]{3,5,3}));
        assertEquals(10, solution.rob(new int[]{3,5,3,5}));
    }
}
