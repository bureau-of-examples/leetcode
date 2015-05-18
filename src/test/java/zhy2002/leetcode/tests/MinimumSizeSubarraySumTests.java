package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.minimumsizesubarraysum.Solution;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySumTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(2, solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        assertEquals(1, solution.minSubArrayLen(7, new int[]{2,3,1,7,2,4,3}));
        assertEquals(0, solution.minSubArrayLen(100, new int[]{2,3,1,7,2,4,3}));
        assertEquals(6, solution.minSubArrayLen(17, new int[]{1,5,4,3,2,2}));


    }

}
