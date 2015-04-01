package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.removeelement.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveElementTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0,solution.removeElement(new int[] {}, 9));
        assertEquals(0,solution.removeElement(new int[] {9}, 9));
        assertEquals(0,solution.removeElement(new int[] {9,9}, 9));
        assertEquals(1,solution.removeElement(new int[] {9, 1, 9}, 9));
        assertEquals(2,solution.removeElement(new int[] {1,9,8}, 9));
        assertEquals(2,solution.removeElement(new int[] {9,1,8}, 9));
        assertEquals(4,solution.removeElement(new int[] {8,7,2,6}, 9));
    }
}
