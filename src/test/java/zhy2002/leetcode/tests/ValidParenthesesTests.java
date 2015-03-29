package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.solutions.validparentheses.Solution;

import static org.junit.Assert.*;

public class ValidParenthesesTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertEquals(true, solution.isValid(""));
        assertEquals(true, solution.isValid("()"));
        assertEquals(true, solution.isValid("()[[]]"));
        assertEquals(true, solution.isValid("{()[[]]}"));
        assertEquals(false, solution.isValid("]{()[[]]}"));
        assertEquals(true, solution.isValid("[]{()[[]]}"));
        assertEquals(true, solution.isValid("([]{()[[]]})"));
        assertEquals(false, solution.isValid("([[]{()[[]]})"));
        assertEquals(false, solution.isValid("([]{()[[]}]})"));
    }
}
