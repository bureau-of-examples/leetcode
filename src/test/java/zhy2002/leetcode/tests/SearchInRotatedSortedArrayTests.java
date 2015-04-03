package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.searchinrotatedsortedarray.Solution;
import static org.junit.Assert.*;

public class SearchInRotatedSortedArrayTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.search(new int[]{5,1,2,3,4}, 5));
        assertEquals(1, solution.search(new int[]{5,6,1,2,3,4}, 6));
        assertEquals(1, solution.search(new int[]{5,6,8,1,2,3,4}, 6));
        assertEquals(0, solution.search(new int[]{5,6,8,9,1,2,3,4}, 5));
        assertEquals(5, solution.search(new int[]{5,6,8,9,1,2,3,4}, 2));
    }
}
