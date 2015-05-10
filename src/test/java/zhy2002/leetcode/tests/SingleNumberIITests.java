package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.singlenumberii.Solution;
import static org.junit.Assert.*;

public class SingleNumberIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals(5, solution.singleNumber(new int[]{5}));
        assertEquals(5, solution.singleNumber(new int[]{5,1,1,1}));
        assertEquals(5, solution.singleNumber(new int[]{1,1,5,1}));
        assertEquals(5, solution.singleNumber(new int[]{2,2,1,5,1,1,2}));
        assertEquals(5, solution.singleNumber(new int[]{2,1,1,1,2,2,5}));
        assertEquals(5, solution.singleNumber(new int[]{5,2,1,1,1,2,2,3,3,3}));


    }
}
