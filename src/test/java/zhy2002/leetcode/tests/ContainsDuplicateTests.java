package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.containsduplicate.Solution;
import static org.junit.Assert.*;

public class ContainsDuplicateTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(false, solution.containsDuplicate(new int[]{}));
        assertEquals(false, solution.containsDuplicate(new int[]{1}));
        assertEquals(false, solution.containsDuplicate(new int[]{1,2}));
        assertEquals(true, solution.containsDuplicate(new int[]{1,3,2,3}));
        assertEquals(false, solution.containsDuplicate(new int[]{5,4,7,2,3,1}));
    }
}
