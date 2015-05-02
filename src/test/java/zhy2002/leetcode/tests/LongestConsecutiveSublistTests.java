package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestconsecutivesublist.Solution;
import static org.junit.Assert.*;

public class LongestConsecutiveSublistTests {

    @Test
    public void basicTests(){
        Solution solution = new Solution();
        assertEquals(0, solution.longestConsecutive(new int[0]));
        assertEquals(1, solution.longestConsecutive(new int[]{1}));
        assertEquals(2, solution.longestConsecutive(new int[]{1,2}));
        assertEquals(2, solution.longestConsecutive(new int[]{9,1,2}));
        assertEquals(2, solution.longestConsecutive(new int[]{9,1,2,11}));
        assertEquals(3, solution.longestConsecutive(new int[]{9,1,2,1,11}));
        assertEquals(4, solution.longestConsecutive(new int[]{9,1,2,1,11,10,11,10}));

    }
}
