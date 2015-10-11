package zhy2002.leetcode.additional;

import zhy2002.leetcode.additional.maximumsubarrayii.Solution;
import org.junit.Test;
import static org.junit.Assert.*;


public class MaximumSubarrayIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(solution.maxContiguous(new int[]{4, -4, 3, -8, 3, -1, 2}), 8);
        assertEquals(solution.maxContiguous(new int[]{1, 2, -1, 1}), 4);
        assertEquals(solution.maxContiguous(new int[]{1, 2, -1, 1, -4}), 3);
        assertEquals(solution.maxContiguous(new int[]{1, 1, 1, 1}), 4);
        assertEquals(solution.maxContiguous(new int[]{1, 1, -3, 1, -2, 1}), 3);
    }
}
