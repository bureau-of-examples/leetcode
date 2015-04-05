package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.firstmissingpositive.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstMissingPositiveTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(4, solution.firstMissingPositive(new int[]{3,0,1,6,2,5,2,1,1,0,-1}));
        assertEquals(5, solution.firstMissingPositive(new int[]{1,2,3,4}));
        assertEquals(2, solution.firstMissingPositive(new int[]{5,4,3,1}));
        assertEquals(6, solution.firstMissingPositive(new int[]{8,5,2,1,3,4,2}));
    }
}
