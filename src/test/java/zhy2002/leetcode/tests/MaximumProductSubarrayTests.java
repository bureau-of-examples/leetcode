package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.solutions.maximumproductsubarray.Solution;
import static org.junit.Assert.*;

public class MaximumProductSubarrayTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.maxProduct(new int[]{}));
        assertEquals(-9, solution.maxProduct(new int[]{-9}));
        assertEquals(72, solution.maxProduct(new int[]{-9, -8}));
        assertEquals(6, solution.maxProduct(new int[]{2,3,-2,4}));
        assertEquals(48, solution.maxProduct(new int[]{2,3,-2,4, -1}));
        assertEquals(12, solution.maxProduct(new int[]{-4,-3,-2}));
        assertEquals(0, solution.maxProduct(new int[]{0, 0, 0}));

    }
}
