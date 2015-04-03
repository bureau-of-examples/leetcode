package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.searchinsertposition.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchInsertPositionTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
    assertEquals(0,solution.searchInsert(new int[]{1}, 1));
    assertEquals(0,solution.searchInsert(new int[]{1}, 0));
    assertEquals(1,solution.searchInsert(new int[]{1}, 2));
    assertEquals(5,solution.searchInsert(new int[]{1,3,5,7,9}, 12));
    assertEquals(0,solution.searchInsert(new int[]{1,3,5,7,9}, 0));
    assertEquals(1,solution.searchInsert(new int[]{1,3,5,7,9}, 2));
    assertEquals(1,solution.searchInsert(new int[]{1,3,5,7,9}, 3));
    }

}
