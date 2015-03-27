package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.stringtointeger.LongSolution;
import zhy2002.leetcode.solutions.stringtointeger.ReferenceSolution;
import zhy2002.leetcode.solutions.stringtointeger.Solution;

import static org.junit.Assert.*;

public class StringToIntegerTests {

    @Test
    public void longBasicTest(){
        basicTest(new LongSolution());
    }

    @Test
    public void referenceBasicTest(){
        basicTest(new ReferenceSolution());
    }

    private void basicTest(Solution solution) {
        assertEquals(121, solution.atoi("121"));
        assertEquals(-1, solution.atoi("-1"));
        assertEquals(Integer.MAX_VALUE, solution.atoi("   9999999999"));
        assertEquals(-2147483648, solution.atoi("  -2147483648"));
        assertEquals(-2147483648, solution.atoi("  -2147483649"));
        assertEquals(0, solution.atoi(" a -2147483649"));
        assertEquals(-2147, solution.atoi("-2147s483649"));
        assertEquals(0, solution.atoi("-0"));
        assertEquals(4234, solution.atoi("  4234fd"));
    }
}
