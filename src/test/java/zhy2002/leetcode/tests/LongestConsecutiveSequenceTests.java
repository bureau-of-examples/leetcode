package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestconsecutivesequence.Solution;
import static org.junit.Assert.*;

public class LongestConsecutiveSequenceTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals(0,solution.longestConsecutive(new int[]{}));
        assertEquals(1,solution.longestConsecutive(new int[]{9, 1, 7}));
        assertEquals(3,solution.longestConsecutive(new int[]{9, 1, 2, 7, 8, 9}));
        assertEquals(4,solution.longestConsecutive(new int[]{9, 1, 2, 3, 4, 7, 8, 9}));
        assertEquals(5,solution.longestConsecutive(new int[]{1, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4}));
        assertEquals(5,solution.longestConsecutive(new int[]{1, 2, 3, 4, 0, 2, 3, 4, 3, 4, 0, 4, 0}));
        assertEquals(4,solution.longestConsecutive(new int[]{3, 2, 1, 2, 3, 4}));//4
        assertEquals(7,solution.longestConsecutive(new int[]{0, -1, -2, -3, -2, -1, 0, 1, 2, 3}));
        assertEquals(3,solution.longestConsecutive(new int[]{0,-1,-2}));
        assertEquals(3,solution.longestConsecutive(new int[]{-1,0,1}));
        assertEquals(7,solution.longestConsecutive(new int[]{-1,0,1,5,4,3,2}));
        assertEquals(4,solution.longestConsecutive(new int[]{77,96,-1,97,1,98,0,99}));
        assertEquals(4,solution.longestConsecutive(new int[]{1,2,3,4,3,2,1}));
    }

}
