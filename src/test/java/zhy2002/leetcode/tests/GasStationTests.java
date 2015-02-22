package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.gasstation.Solution;

import static org.junit.Assert.*;

public class GasStationTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        int result = solution.canCompleteCircuit(new int[]{1,1,1}, new int[]{2,2,2});
        assertEquals(-1, result);

        result = solution.canCompleteCircuit(new int[]{1,1,3}, new int[]{2,2,1});
        assertEquals(2, result);

        result = solution.canCompleteCircuit(new int[]{5,1,3,5}, new int[]{4,7,2,1});
        assertEquals(2, result);

        result = solution.canCompleteCircuit(new int[]{5,1,3,5}, new int[]{4,7,2,1});
        assertEquals(2, result);

        result = solution.canCompleteCircuit(new int[]{1,1,3,4,1,1}, new int[]{3,2,1,1,2,2});
        assertEquals(2, result);

        result = solution.canCompleteCircuit(new int[]{2,4}, new int[]{3,4});
        assertEquals(-1, result);
    }
}
