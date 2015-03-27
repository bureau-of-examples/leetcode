package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.reverseinteger.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseIntegerTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        assertEquals(0,solution.reverse(0));
        assertEquals(1,solution.reverse(10));
        assertEquals(1,solution.reverse(10000));
        assertEquals(432,solution.reverse(234));
        assertEquals(654321,solution.reverse(123456));
        assertEquals(65432001,solution.reverse(10023456));
        assertEquals(0,solution.reverse(1000000009));
        assertEquals(0,solution.reverse(1534236469));
        assertEquals(0,solution.reverse(1534236479));
        assertEquals(0,solution.reverse(-2147483648));
    }
}
