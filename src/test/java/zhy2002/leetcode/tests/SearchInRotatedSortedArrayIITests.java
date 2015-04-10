package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.searchinrotatedsortedarrayii.Solution;
import static org.junit.Assert.*;

public class SearchInRotatedSortedArrayIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(false, solution.search(new int[]{}, 3));
        assertEquals(true, solution.search(new int[]{3}, 3));
        assertEquals(true, solution.search(new int[]{4,4,3}, 3));
        assertEquals(false, solution.search(new int[]{4,4,4}, 3));
        assertEquals(true, solution.search(new int[]{3,3,3,3,3,1,2,3,3}, 3));
        assertEquals(false, solution.search(new int[]{3,3,3,3,3,1,2,3,3}, 0));
        assertEquals(true, solution.search(new int[]{3,3,3,3,3,1,2,3,3}, 1));
        assertEquals(false, solution.search(new int[]{3,3,3,3,3,1,2,3,3}, 4));
        assertEquals(false, solution.search(new int[]{3,3,3,3,3,1,2}, 4));
        assertEquals(true, solution.search(new int[]{3,3,3,3,3,1,2}, 1));
        assertEquals(true, solution.search(new int[]{3,1,2}, 2));
        assertEquals(false, solution.search(new int[]{3,1,3}, 2));
        assertEquals(true, solution.search(new int[]{3,1,3}, 1));
        assertEquals(true, solution.search(new int[]{3,1,3}, 3));
        assertEquals(true, solution.search(new int[]{4,5,1,2,3}, 2));
        assertEquals(true, solution.search(new int[]{4,5,1,2,3}, 4));
        assertEquals(true, solution.search(new int[]{4,5,1,2,3}, 3));
        assertEquals(false, solution.search(new int[]{4,5,1,2,3}, 0));
    }
}
