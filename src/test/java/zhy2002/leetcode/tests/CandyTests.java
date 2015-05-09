package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.candy.Solution;
import static org.junit.Assert.*;

public class CandyTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.candy(new int[]{}));
        assertEquals(4, solution.candy(new int[]{1, 2, 2}));
        assertEquals(3, solution.candy(new int[]{1, 1, 1}));
        assertEquals(9, solution.candy(new int[]{1, 2, 4, 4, 3}));
        assertEquals(15, solution.candy(new int[]{5, 1, 1, 1, 10, 2, 1, 1, 1, 3}));
    }
}
