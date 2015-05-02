package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestmonotonoussublist.Solution;
import static org.junit.Assert.*;

public class LongestMonotonousSublistTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.longestConsecutive(new int[]{}));
        assertEquals(1, solution.longestConsecutive(new int[]{1}));
        assertEquals(1, solution.longestConsecutive(new int[]{1,9}));
        assertEquals(2, solution.longestConsecutive(new int[]{1,0}));
        assertEquals(2, solution.longestConsecutive(new int[]{1,0,1}));
        assertEquals(3, solution.longestConsecutive(new int[]{1,0,-1,1}));
        assertEquals(6, solution.longestConsecutive(new int[]{1,0,-1,0,1,2,3,4}));
        assertEquals(6, solution.longestConsecutive(new int[]{1,0,-1,0,1,2,3,4,3}));
    }
}
