package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.kthlargestelementinanarray.Solution;
import static org.junit.Assert.*;

public class KthLargestElementInAnArrayTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(1, solution.findKthLargest(new int[]{1}, 1));
        assertEquals(2, solution.findKthLargest(new int[]{1,2}, 1));
        assertEquals(2, solution.findKthLargest(new int[]{2,1}, 1));
        assertEquals(1, solution.findKthLargest(new int[]{1,2}, 2));
        assertEquals(1, solution.findKthLargest(new int[]{2,1}, 2));
        assertEquals(3, solution.findKthLargest(new int[]{3,1,2}, 1));
        assertEquals(2, solution.findKthLargest(new int[]{2,3,1}, 2));
        assertEquals(1, solution.findKthLargest(new int[]{1,3,2}, 3));
        assertEquals(4, solution.findKthLargest(new int[]{4,4,4}, 1));
        assertEquals(5, solution.findKthLargest(new int[]{3,4,3,5,2,1,4,5,1,1,6}, 3));
    }
}
