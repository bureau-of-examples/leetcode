package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.containsduplicateii.Solution;
import static org.junit.Assert.*;

public class ContainsDuplicateIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals(false, solution.containsNearbyDuplicate(new int[]{}, 10));
        assertEquals(false, solution.containsNearbyDuplicate(new int[]{1,2,3,1}, 2));
        assertEquals(true, solution.containsNearbyDuplicate(new int[]{1,2,1}, 2));
        assertEquals(true, solution.containsNearbyDuplicate(new int[]{1,2,1,3,1}, 3));
    }
}
